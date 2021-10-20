package com.qk.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface ArticleService extends IService<ArticleModel> {


    int updateBatch(List<ArticleModel> list);

    int batchInsert(List<ArticleModel> list);

    /**
     * 文章分页
     *
     * @param cmd 查询条件
     * @return 文章分页
     */
    IPage<ArticlePageVo> getArticlePage(ArticleSearchCmd cmd);

    ArticlePageVo getById(Long id);

    Integer getArticleCount();
}





