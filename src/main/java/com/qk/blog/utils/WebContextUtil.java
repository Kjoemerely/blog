package com.qk.blog.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 获取Web上下文工具类
 *
 * @author qk
 * @since 2021/10/14 16:12
 */
public class WebContextUtil {

    /**
     * 获取HTTP请求
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

}
