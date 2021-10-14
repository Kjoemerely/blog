package com.qk.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qk.blog.common.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="文章信息")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "article")
public class ArticleModel extends BaseModel {
    /**
     * 文章标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="文章标题")
    private String title;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value="文章内容")
    private String content;

    /**
     * 文章分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value="文章分类id")
    private Long categoryId;
}