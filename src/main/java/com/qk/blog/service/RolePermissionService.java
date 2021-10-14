package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.RolePermissionModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface RolePermissionService extends IService<RolePermissionModel> {


    int updateBatch(List<RolePermissionModel> list);

    int batchInsert(List<RolePermissionModel> list);

}





