package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qk.blog.model.CommentModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qk
 * @since 2021/10/14 14:45
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentModel> {
    int updateBatch(List<CommentModel> list);

    int batchInsert(@Param("list") List<CommentModel> list);
}