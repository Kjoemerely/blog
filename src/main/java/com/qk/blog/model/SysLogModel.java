package com.qk.blog.model;

import com.qk.blog.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日志信息
 * 数据库表：sys_log
 *
 * @author admin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysLogModel extends BaseModel {

    @ApiModelProperty(value = "日志类别")
    private String logType;

    @ApiModelProperty(value = "日志类别名称")
    private String logTypeName;

    @ApiModelProperty(value = "日志子类别")
    private String secondType;

    @ApiModelProperty(value = "日志子类别名称")
    private String secondTypeName;

    @ApiModelProperty(value = "业务id")
    private Long businessId;

    @ApiModelProperty(value = "业务名称")
    private String businessName;

    @ApiModelProperty(value = "日志内容")
    private String comment;

    @ApiModelProperty(value = "操作客户端ip")
    private String ip;

    @ApiModelProperty(value = "操作客户端host名称")
    private String host;

    @ApiModelProperty(value = "浏览器")
    private String browser;

    @ApiModelProperty(value = "协议")
    private String protocol;

    @ApiModelProperty(value = "操作系统")
    private String os;

}