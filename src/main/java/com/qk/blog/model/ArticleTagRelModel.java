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
 * 文章-标签关系
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="文章-标签关系")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "article_tag_rel")
public class ArticleTagRelModel extends BaseModel {
    /**
     * 文章id
     */
    @TableField(value = "article_id")
    @ApiModelProperty(value="文章id")
    private Long articleId;

    /**
     * 标签id
     */
    @TableField(value = "tag_id")
    @ApiModelProperty(value="标签id")
    private Long tagId;
}