package com.qk.blog.service.impl;

import com.qk.blog.model.ArticleTagRelModel;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.ArticleTagRelMapper;

import com.qk.blog.service.ArticleTagRelService;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class ArticleTagRelServiceImpl extends ServiceImpl<ArticleTagRelMapper, ArticleTagRelModel> implements ArticleTagRelService {

    @Override
    public int updateBatch(List<ArticleTagRelModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ArticleTagRelModel> list) {
        return baseMapper.batchInsert(list);
    }
}





