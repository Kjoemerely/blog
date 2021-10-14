package com.qk.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qk.blog.dao.CommentMapper;
import com.qk.blog.model.CommentModel;
import com.qk.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qk
 * @since 2021/10/14 14:41
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentModel> implements CommentService {

    @Override
    public int updateBatch(List<CommentModel> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<CommentModel> list) {
        return baseMapper.batchInsert(list);
    }
}





