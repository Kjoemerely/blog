package com.qk.blog.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.ArticleTagRelModel;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface ArticleTagRelService extends IService<ArticleTagRelModel> {


    int updateBatch(List<ArticleTagRelModel> list);

    int batchInsert(List<ArticleTagRelModel> list);

}





