package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qk.blog.model.ArticleModel;
import com.qk.blog.vo.ArticlePageVo;
import com.qk.blog.vo.ArticleSearchCmd;
import com.qk.blog.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/21 13:51
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleModel> {
    int updateBatch(List<ArticleModel> list);

    int batchInsert(@Param("list") List<ArticleModel> list);

    IPage<ArticlePageVo> getArticlePage(Page<ArticlePageVo> page, @Param("cmd") ArticleSearchCmd cmd);

    ArticleVo getById(Long id);
}