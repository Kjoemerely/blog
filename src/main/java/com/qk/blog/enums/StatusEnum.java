package com.qk.blog.enums;

/**
 * 状态枚举
 *
 * @author qk
 * @since 2021/10/14 15:02
 */
public enum StatusEnum {

    /**
     * 暂停
     */
    PAUSE("PAUSE","暂停"),
    BAN("BAN","封禁"),
    NORMAL("NORMAL","正常"),
    DELETED("DELETED","已删除"),
    ;

    private String code;

    private String message;

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

    StatusEnum (String code, String message) {
        this.code = code;
        this.message = message;
    }
}
