package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.PermissionModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface PermissionService extends IService<PermissionModel> {


    int updateBatch(List<PermissionModel> list);

    int batchInsert(List<PermissionModel> list);

}





