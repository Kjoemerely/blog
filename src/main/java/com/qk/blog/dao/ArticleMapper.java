package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qk.blog.model.ArticleModel;
import java.util.List;
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
}