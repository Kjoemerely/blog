package com.qk.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qk.blog.common.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章评论信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value = "文章评论信息")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`comment`")
public class CommentModel extends BaseModel {
    /**
     * 评论内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "评论内容")
    private String content;

    /**
     * 文章id
     */
    @TableField(value = "article_id")
    @ApiModelProperty(value = "文章id")
    private Long articleId;

    /**
     * 评论父id，一级为#
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "评论父id，一级为#")
    private Long parentId;
}