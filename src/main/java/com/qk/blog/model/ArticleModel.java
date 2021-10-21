package com.qk.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qk.blog.common.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qk
 * @since 2021/10/21 13:51
 */

/**
 * 文章信息
 */
@ApiModel(value = "文章信息")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "article")
public class ArticleModel extends BaseModel {
    /**
     * 文章标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "文章标题")
    private String title;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "文章内容")
    private String content;

    /**
     * 文章分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "文章分类id")
    private Long categoryId;

    /**
     * 图片地址
     */
    @TableField(value = "cover_image")
    @ApiModelProperty(value = "图片地址")
    private String coverImage;

    /**
     * 允许评论，允许-ENABLE，禁止-DISABLE
     */
    @TableField(value = "enable_comment")
    @ApiModelProperty(value = "允许评论，允许-ENABLE，禁止-DISABLE")
    private String enableComment;
}