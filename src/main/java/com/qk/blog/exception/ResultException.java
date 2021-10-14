package com.qk.blog.exception;

import com.qk.blog.common.Result;
import com.qk.blog.enums.ErrorResultEnum;

/**
 * @author qk
 * @since 2021/10/14 15:17
 */
public class ResultException extends Exception {

    private String code;

    public String getCode() {
        return code;
    }

    public ResultException(ErrorResultEnum errorResult){
        super(errorResult.getMessage());
        this.code = errorResult.getCode();
    }

    public ResultException(String message){
        super(message);
        this.code = Result.RESULT_ERROR_MSG;
    }
}
