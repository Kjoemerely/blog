package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.CategoryMapper;
import com.qk.blog.model.CategoryModel;
import com.qk.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryModel> implements CategoryService {

    @Override
    public int updateBatch(List<CategoryModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<CategoryModel> list) {
        return baseMapper.batchInsert(list);
    }
}





