package com.qk.blog.vo;

import com.qk.blog.model.ArticleModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qk
 * @since 2021/10/15 13:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticlePageVo extends ArticleModel {

    private Integer commentCount;

    private String categoryName;

    private String tagNames;

}
