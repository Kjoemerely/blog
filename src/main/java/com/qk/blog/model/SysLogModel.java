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
 * @since 2021/10/18 17:46
 */

/**
 * 系统日志
 */
@ApiModel(value = "系统日志")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_log")
public class SysLogModel extends BaseModel {
    /**
     * 一级分类
     */
    @TableField(value = "first_type")
    @ApiModelProperty(value = "一级分类")
    private String firstType;

    /**
     * 一级分类名称
     */
    @TableField(value = "first_type_name")
    @ApiModelProperty(value = "一级分类名称")
    private String firstTypeName;

    /**
     * 二级分类
     */
    @TableField(value = "second_type")
    @ApiModelProperty(value = "二级分类")
    private String secondType;

    /**
     * 二级分类名称
     */
    @TableField(value = "second_type_name")
    @ApiModelProperty(value = "二级分类名称")
    private String secondTypeName;

    /**
     * 业务id
     */
    @TableField(value = "business_id")
    @ApiModelProperty(value = "业务id")
    private Long businessId;

    /**
     * 业务名称
     */
    @TableField(value = "business_name")
    @ApiModelProperty(value = "业务名称")
    private String businessName;

    /**
     * 日志内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "日志内容")
    private String content;

    /**
     * 操作客户端ip地址
     */
    @TableField(value = "ip_address")
    @ApiModelProperty(value = "操作客户端ip地址")
    private String ipAddress;

    /**
     * 操作客户端host名称
     */
    @TableField(value = "`host`")
    @ApiModelProperty(value = "操作客户端host名称")
    private String host;

    /**
     * 浏览器
     */
    @TableField(value = "browser")
    @ApiModelProperty(value = "浏览器")
    private String browser;

    /**
     * 协议
     */
    @TableField(value = "protocol")
    @ApiModelProperty(value = "协议")
    private String protocol;
}