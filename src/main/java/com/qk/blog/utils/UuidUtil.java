package com.qk.blog.utils;

import java.util.UUID;

/**
 * @author qk
 * @since 2021/10/14 16:26
 */
public class UuidUtil {

    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String result = uuid.toString();
        return result.replaceAll("-", "");
    }

}
