package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.SysLogModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/18 17:46
 */
public interface SysLogService extends IService<SysLogModel> {

    void addExceptionLog(Exception e);

    int addSysLog(SysLogModel model);

    int updateBatch(List<SysLogModel> list);

    int batchInsert(List<SysLogModel> list);

}
