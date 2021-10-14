package com.qk.blog.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.ArticleModel;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface ArticleService extends IService<ArticleModel> {


    int updateBatch(List<ArticleModel> list);

    int batchInsert(List<ArticleModel> list);

}





