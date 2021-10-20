package com.qk.blog.enums;

/**
 * @author qk
 * @since 2021/10/18 17:51
 */
public enum LogTypeEnum {

    /**
     * 一级分类
     */
    USER("USER","用户"),
    ARTICLE("ARTICLE","文章"),
    CATEGORY("CATEGORY","分类"),
    TAG("TAG","标签"),

    /**
     * 二级分类
      */
    INSERT("INSERT","新增"),
    DELETE("DELETE","修改"),
    SELECT("SELECT","查询"),
    UPDATE("UPDATE","修改"),
    LOGIN("LOGIN","登录"),
    ;

    private String code;

    private String message;

    LogTypeEnum (String code, String message) {
        this.code = code;
        this.message = message;
    }

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

}
