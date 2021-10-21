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

    private static final LinkedHashMap<String, String> statusMap = EnumUtil.enumToMap(StatusEnum.class);

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
     * 文章分页
     *
     * @param cmd 查询条件
     * @return 文章分页
     */
    @Override
    public IPage<ArticlePageVo> getArticlePage(ArticleSearchCmd cmd) {
        Page<ArticlePageVo> page = new Page<>(cmd.getPage(), cmd.getRows());
        IPage<ArticlePageVo> iPage = articleMapper.getArticlePage(page, cmd);
        for (ArticlePageVo record : iPage.getRecords()) {
            record.setStatus(statusMap.get(record.getStatus()));
        }
        return iPage;
    }

    @Override
    public ArticlePageVo getById(Long id) {
        return articleMapper.getById(id);
    }

    @Override
    public Integer getArticleCount() {
        LambdaQueryWrapper<ArticleModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleModel::getStatus, StatusEnum.NORMAL.getCode());
        return articleMapper.selectCount(wrapper);
    }

    @Override
    public Result saveArticle(Result result, ArticleVo vo) throws Exception {
        ArticleModel model = new ArticleModel();
        BeanUtils.copyProperties(vo, model);
        articleMapper.insert(model);
        return result;
    }
}






