package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qk.blog.common.PageQueryCmd;
import com.qk.blog.model.ArticleModel;

import java.util.List;

import com.qk.blog.vo.ArticlePageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qk
 * @since 2021/10/14 14:45
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleModel> {

    int updateBatch(List<ArticleModel> list);

    int batchInsert(@Param("list") List<ArticleModel> list);

    IPage<ArticlePageVo> getArticlePage(Page<ArticlePageVo> page, PageQueryCmd cmd);

}