package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.PermissionMapper;
import com.qk.blog.model.PermissionModel;
import com.qk.blog.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionModel> implements PermissionService {

    @Override
    public int updateBatch(List<PermissionModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<PermissionModel> list) {
        return baseMapper.batchInsert(list);
    }
}





