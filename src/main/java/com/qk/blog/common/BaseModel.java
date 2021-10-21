package com.qk.blog.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础公共类
 * <p>
 * 解决redis序列化LocalDateTime问题：
 * JsonDeserialize(using = LocalDateTimeDeserializer.class)
 * JsonSerialize(using = LocalDateTimeSerializer.class)
 *
 * @author qk
 * @since 2021/10/14 13:53
 */
@Data
public class BaseModel {

    @ApiModelProperty
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "状态")
    @TableField(value = "status")
    private String status;

    @ApiModelProperty(value = "创建人id")
    @TableField(value = "create_user_id")
    private Long createUserId;

    @ApiModelProperty(value = "创建人名称")
    @TableField(value = "create_user_name")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人id")
    @TableField(value = "update_user_id")
    private Long updateUserId;

    @ApiModelProperty(value = "修改人名称")
    @TableField(value = "update_user_name")
    private String updateUserName;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
