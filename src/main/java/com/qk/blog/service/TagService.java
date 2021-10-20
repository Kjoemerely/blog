package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.TagModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface TagService extends IService<TagModel> {


    int updateBatch(List<TagModel> list);

    int batchInsert(List<TagModel> list);

    Integer getTagCount();
}





