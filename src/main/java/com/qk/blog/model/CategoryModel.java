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
 * 文章分类信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="文章分类信息")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "category")
public class CategoryModel extends BaseModel {
    /**
     * 分类名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="分类名称")
    private String name;
}