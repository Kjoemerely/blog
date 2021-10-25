package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.common.Result;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.ArticleVo;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface ArticleService extends IService<ArticleModel> {


    int updateBatch(List<ArticleModel> list);

    int batchInsert(List<ArticleModel> list);

    /**
     * 查询文章数量
     *
     * @return 文章数量
     */
    Integer getArticleCount();

    /**
     * 文章分页
     *
     * @param result 通用返回结果
     * @param cmd    查询条件
     * @return 文章分页
     * @throws Exception 异常信息
     */
    Result getArticleList(Result result, ArticleSearchCmd cmd) throws Exception;

    /**
     * 查询文章详情
     *
     * @param id 文章id
     * @return 文章详情
     * @throws Exception 异常信息
     */
    ArticleVo getById(Long id) throws Exception;

    /**
     * 保存文章
     *
     * @param result 通用返回结果
     * @param vo     文章信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    Result saveArticle(Result result, ArticleVo vo) throws Exception;

    /**
     * 修改文章
     *
     * @param result 通用返回结果
     * @param vo     文章信息
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    Result updateArticle(Result result, ArticleVo vo) throws Exception;

    /**
     * 删除文章
     *
     * @param result 通用返回结果
     * @param id     文章id
     * @return 通用返回结果
     * @throws Exception 异常信息
     */
    Result deleteArticle(Result result, Long id) throws Exception;
}