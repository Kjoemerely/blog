package com.qk.blog.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qk.blog.common.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色-权限关系信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value = "角色-权限关系信息")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_permission")
public class RolePermissionModel extends BaseModel {
    /**
     * 角色id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 权限id
     */
    @TableField(value = "permission_id")
    @ApiModelProperty(value = "权限id")
    private Long permissionId;
}