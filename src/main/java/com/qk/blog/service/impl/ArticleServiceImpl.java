package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.ArticleMapper;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.service.ArticleService;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {

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
}





