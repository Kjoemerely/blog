package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.TagMapper;
import com.qk.blog.enums.StatusEnum;
import com.qk.blog.model.TagModel;
import com.qk.blog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagModel> implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public int updateBatch(List<TagModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TagModel> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Integer getTagCount() {
        LambdaQueryWrapper<TagModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TagModel::getStatus, StatusEnum.NORMAL.getCode());
        return tagMapper.selectCount(wrapper);

    }
}





