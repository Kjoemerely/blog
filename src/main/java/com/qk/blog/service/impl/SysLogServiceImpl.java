package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.SysLogMapper;
import com.qk.blog.model.SysLogModel;
import com.qk.blog.service.SysLogService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author qk
 * @since 2021/10/18 17:46
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogModel> implements SysLogService{

    @Override
    public void addExceptionLog(Exception e) {

    }

    @Override
    public int addSysLog(SysLogModel model) {
        return 0;
    }

    @Override
    public int updateBatch(List<SysLogModel> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<SysLogModel> list) {
        return baseMapper.batchInsert(list);
    }
}
