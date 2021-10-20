package com.qk.blog.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author qk
 * @since 2021/10/14 13:53
 */
@Data
public class BaseModel {

    @ApiModelProperty
    private Long id;

    @ApiModelProperty(value="状态")
    private String status;

    @ApiModelProperty(value="创建人id")
    private Long createUserId;

    @ApiModelProperty(value="创建人名称")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value="修改人id")
    private Long updateUserId;

    @ApiModelProperty(value="修改人名称")
    private String updateUserName;

    @ApiModelProperty(value = "修改时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
