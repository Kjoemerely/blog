package com.qk.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qk.blog.common.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章标签信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value = "文章标签信息")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tag")
public class TagModel extends BaseModel {
    /**
     * 标签名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "标签名称")
    private String name;

    /**
     * 文章id
     */
    @TableField(value = "article_id")
    @ApiModelProperty(value = "文章id")
    private Long articleId;
}