package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qk.blog.model.RoleModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qk
 * @since 2021/10/14 14:45
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleModel> {
    int updateBatch(List<RoleModel> list);

    int batchInsert(@Param("list") List<RoleModel> list);
}