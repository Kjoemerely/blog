package com.qk.blog.service.impl;

import com.qk.blog.model.ArticleModel;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qk.blog.dao.ArticleMapper;
import com.qk.blog.service.ArticleService;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {

    @Override
    public int updateBatch(List<ArticleModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ArticleModel> list) {
        return baseMapper.batchInsert(list);
    }
}





