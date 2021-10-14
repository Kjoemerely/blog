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
 * 角色信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="角色信息")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "`role`")
public class RoleModel extends BaseModel {
    /**
     * 角色名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="角色名称")
    private String name;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;
}