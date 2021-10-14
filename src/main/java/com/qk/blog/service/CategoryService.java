package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.CategoryModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface CategoryService extends IService<CategoryModel> {


    int updateBatch(List<CategoryModel> list);

    int batchInsert(List<CategoryModel> list);

}





