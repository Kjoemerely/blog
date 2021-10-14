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
 * 权限信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="权限信息")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "permission")
public class PermissionModel extends BaseModel {
    /**
     * 权限名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="权限名称")
    private String name;

    /**
     * 父id，一级为#
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value="父id，一级为#")
    private Long parentId;
}