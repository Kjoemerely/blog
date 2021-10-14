package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.RoleModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface RoleService extends IService<RoleModel> {


    int updateBatch(List<RoleModel> list);

    int batchInsert(List<RoleModel> list);

}





