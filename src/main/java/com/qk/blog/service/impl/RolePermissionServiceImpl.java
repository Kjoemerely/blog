package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.RolePermissionMapper;
import com.qk.blog.model.RolePermissionModel;
import com.qk.blog.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermissionModel> implements RolePermissionService {

    @Override
    public int updateBatch(List<RolePermissionModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<RolePermissionModel> list) {
        return baseMapper.batchInsert(list);
    }
}





