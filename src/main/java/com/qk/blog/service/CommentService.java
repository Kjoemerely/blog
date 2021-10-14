package com.qk.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qk.blog.model.CommentModel;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
public interface CommentService extends IService<CommentModel> {


    int updateBatch(List<CommentModel> list);

    int batchInsert(List<CommentModel> list);

}





