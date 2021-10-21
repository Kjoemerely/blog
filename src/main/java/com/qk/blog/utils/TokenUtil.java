package com.qk.blog.utils;

/**
 * @author qk
 * @since 2021/10/14 16:11
 */
public class TokenUtil {

    public static String getToken(){
        Object token = WebContextUtil.getRequest().getSession().getAttribute("token");
        return token != null ? token.toString() : "";
    }

}
