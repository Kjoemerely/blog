package com.qk.blog.utils;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * @author qk
 * @since 2021/10/14 15:54
 */
public class EnumUtil {

    /**
     * 枚举转map结合id作为map的key,name作为map的value
     *
     * @param enumT       枚举类
     * @param methodNames 方法
     * @return enum map
     */
    public static <T> LinkedHashMap<String, String> enumToMap(Class<T> enumT, String... methodNames) {
        LinkedHashMap<String, String> enummap = new LinkedHashMap<>();
        if (!enumT.isEnum()) {
            return enummap;
        }
        T[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return enummap;
        }
        int count = methodNames.length;
        String valueMethod = "getCode";
        String desMethod = "getMessage";
        //扩展方法
        if (count >= 1 && !"".equals(methodNames[0])) {
            valueMethod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMethod = methodNames[1];
        }
        for (T tobj : enums) {
            try {
                //获取value值
                Object resultValue = getMethodValue(valueMethod, tobj);
                if ("".equals(resultValue)) {
                    continue;
                }
                //获取description描述值
                Object resultDes = getMethodValue(desMethod, tobj);
                if ("".equals(resultDes)) {
                    //如果描述不存在获取属性值
                    resultDes = tobj;
                }
                if (resultValue instanceof Integer) {
                    //如果是integer，强转为String
                    resultValue = String.valueOf(resultValue);
                }
                enummap.put(resultValue.toString(), resultDes + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return enummap;
    }

    /**
     * 根据反射，通过方法名称获取方法值，忽略大小写的
     *
     * @param methodName 方法名
     * @param obj        对象
     * @param args       参数
     * @return value
     */
    private static <T> Object getMethodValue(String methodName, T obj, Object... args) {
        Object result = "";
        try {
            // 获取方法数组，这里只要共有的方法
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return result;
            }
            Method method = null;
            for (Method value : methods) {
                // 忽略大小写取方法
                if (value.getName().equalsIgnoreCase(methodName)) {
                    method = value;
                    break;
                }
            }
            if (method == null) {
                return result;
            }
            // 方法执行
            result = method.invoke(obj, args);
            if (result == null) {
                result = "";
            }
            // 返回结果
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}