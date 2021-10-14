package com.qk.blog.utils;

import com.qk.blog.enums.CommonConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @author qk
 * @since 2021/10/14 16:11
 */
public class TokenUtil {

    public static String getToken(){
        String token = WebContextUtil.getRequest().getHeader(CommonConstant.DEFAULT_TOKEN_NAME);
        if(StringUtils.isEmpty(token)){
            token = WebContextUtil.getRequest().getHeader(CommonConstant.REQUEST_TOKEN_NAME);
        }
        return token;
    }

}
