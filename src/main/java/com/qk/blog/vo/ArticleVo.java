package com.qk.blog.vo;

import com.qk.blog.model.ArticleModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qk
 * @since 2021/10/18 9:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleVo extends ArticleModel {

    private String tagIds;

}
