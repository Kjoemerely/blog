package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.RoleMapper;
import com.qk.blog.model.RoleModel;
import com.qk.blog.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {

    @Override
    public int updateBatch(List<RoleModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<RoleModel> list) {
        return baseMapper.batchInsert(list);
    }
}





