package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.CategoryMapper;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.CategoryModel;
import com.qk.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryModel> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int updateBatch(List<CategoryModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<CategoryModel> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Integer getCategoryCount() {
        LambdaQueryWrapper<CategoryModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryModel::getStatus, StatusEnum.NORMAL.getCode());
        return categoryMapper.selectCount(wrapper);
    }

    @Override
    public List<CategoryModel> getAllCategorys() {
        LambdaQueryWrapper<CategoryModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryModel::getStatus, StatusEnum.NORMAL.getCode());
        return categoryMapper.selectList(wrapper);
    }
}





