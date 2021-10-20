package com.qk.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qk.blog.model.SysLogModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/18 17:46
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogModel> {

    void addExceptionLog(Exception e);

    int updateBatch(List<SysLogModel> list);

    int batchInsert(@Param("list") List<SysLogModel> list);
}