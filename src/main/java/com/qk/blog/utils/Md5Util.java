package com.qk.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author qk
 * @since 2021/10/14 15:58
 */
public class Md5Util {

    private static final Logger log = LoggerFactory.getLogger(Md5Util.class);
    private static final String[] HEX_DIGITS = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"};

    public Md5Util() {
    }

    /**
     * md5 加密
     *
     * @param source 明文
     * @param salt   盐值
     * @return 加密结果
     */
    public static String md5Encode(String source, String salt) {
        try {
            return md5Encode(md5Encode(source) + salt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * md5 加密
     *
     * @param source 原文
     * @return 加密结果
     * @throws Exception 异常信息
     */
    public static String md5Encode(String source) throws Exception {
        String result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(source.getBytes(StandardCharsets.UTF_8));
            result = byteArrayToHexString(messageDigest.digest());
        } catch (Exception var5) {
            log.error("密码转换出错", var5);
            throw var5;
        }

        return result;
    }

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    public static void main(String[] args) {
        try {
            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            salt = salt.substring(0, 6);
            String password = Md5Util.md5Encode("admin");
            System.out.println(password);
            System.out.println(salt);
            System.out.println(Md5Util.md5Encode(password + salt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
