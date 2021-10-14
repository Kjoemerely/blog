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
 * 用户信息
 *
 * @author qk
 * @since 2021/10/14 14:45
 */
@ApiModel(value="用户信息")
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "`user`")
public class UserModel extends BaseModel {
    /**
     * 用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    @ApiModelProperty(value="昵称")
    private String nickName;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 用户来源，注册-REGIST，管理员分配-DISTRIBUTE
     */
    @TableField(value = "`source`")
    @ApiModelProperty(value="用户来源，注册-REGIST，管理员分配-DISTRIBUTE")
    private String source;
}