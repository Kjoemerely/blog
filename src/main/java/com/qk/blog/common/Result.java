package com.qk.blog.common;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author qk
 * @since 2021/10/14 15:15
 */
public class Result implements Serializable {

    /**
     * 成功
     */
    public final static String RESULT_SUCCESS = "0";
    public final static String RESULT_COMPILE_HTML = "2";
    public final static String RESULT_SUCCESS_MSG = "操作成功";

    /**
     * 失败
     */
    public final static String RESULT_ERROR = "1";
    public final static String RESULT_ERROR_MSG = "操作失败";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "状态码", required = false)
    private String code = RESULT_SUCCESS;

    /**
     * 返回提示语
     */
    @ApiModelProperty(value = "提示语", required = false)
    private String message = RESULT_SUCCESS_MSG;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", required = false)
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
