package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.common.Result;
import com.qk.blog.dao.ArticleMapper;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.service.ArticleService;
import com.qk.blog.utils.EnumUtil;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {

    private final LinkedHashMap<String, String> statusMap = EnumUtil.enumToMap(StatusEnum.class);

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public int updateBatch(List<ArticleModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ArticleModel> list) {
        return baseMapper.batchInsert(list);
    }

    /**
     * 查询文章数量
     *
     * @return 文章数量
     */
    @Override
    public Integer getArticleCount() {
        LambdaQueryWrapper<ArticleModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleModel::getStatus, StatusEnum.NORMAL.getCode());
        return articleMapper.selectCount(wrapper);
    }

    /**
     * 文章分页
     *
     * @param result 通用返回结果
     * @param cmd    查询条件
     * @return 文章分页
     * @throws Exception 异常信息
     */
    @Override
    public Result getArticleList(Result result, ArticleSearchCmd cmd) throws Exception {
        Page<ArticlePageVo> page = new Page<>(cmd.getPage(), cmd.getRows());
        IPage<ArticlePageVo> iPage = articleMapper.getArticlePage(page, cmd);
        for (ArticlePageVo record : iPage.getRecords()) {
            record.setStatus(statusMap.get(record.getStatus()));
        }
        result.setData(iPage);
        return result;
    }

    /**
     * 查询文章详情
     *
     * @param id 文章id
     * @return 文章详情
     * @throws Exception 异常信息
     */
    @Override
    public ArticleVo getById(Long id) throws Exception {
        return articleMapper.getById(id);
    }

    /**
     * 保存文章
     *
     * @param result 通用返回结果
     * @param vo     文章信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    @Override
    public Result saveArticle(Result result, ArticleVo vo) throws Exception {
        ArticleModel model = new ArticleModel();
        BeanUtils.copyProperties(vo, model);
        articleMapper.insert(model);
        return result;
    }

    /**
     * 修改文章
     *
     * @param result 通用返回结果
     * @param vo     文章信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    @Override
    public Result updateArticle(Result result, ArticleVo vo) throws Exception {
        articleMapper.updateById(vo);
        return result;
    }

    /**
     * 删除文章
     *
     * @param result 通用返回结果
     * @param id     文章id
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    @Override
    public Result deleteArticle(Result result, Long id) throws Exception {
        articleMapper.deleteById(id);
        return result;
    }

}