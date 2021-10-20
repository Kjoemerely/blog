package com.qk.blog.utils;


import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author admin
 */
public class RequestUtil {

    public RequestUtil() {

    }

    public static HashMap<String, String[]> getRequestParameterMap(HttpServletRequest request) {
        HashMap<String, String[]> hmReturn = new HashMap<>();
        if (request != null) {
            for (String s : request.getParameterMap().keySet()) {
                String sParameterName = "" + s;
                hmReturn.put(sParameterName, request.getParameterMap().get(sParameterName));
            }
        }
        return hmReturn;
    }

    public static void printInConsole(HttpServletRequest request) {
        HashMap<String, String[]> map = getRequestParameterMap(request);
        Set<String> keySet = map.keySet();
        System.out.println("****print request parameter");

        String key;
        StringBuilder tmp;
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); System.out.println("**" + key + "=" + tmp)) {
            key = iterator.next();
            Object value = request.getParameterMap().get(key);
            tmp = new StringBuilder();
            if (value != null) {
                String[] values = (String[]) value;
                for (int i = 0; i < values.length; ++i) {
                    if (i != 0) {
                        tmp.append(",");
                    }
                    tmp.append(values[i]);
                }
            } else {
                tmp = new StringBuilder();
            }
        }
    }

    public static Version getBrowserVersion(HttpServletRequest request) {
        UserAgent userAgent = getUserAgent(request);
        return null != userAgent ? userAgent.getBrowserVersion() : null;
    }

    public static Browser getBrowser(HttpServletRequest request) {
        UserAgent userAgent = getUserAgent(request);
        return null != userAgent ? userAgent.getBrowser() : null;
    }

    public static OperatingSystem getOperatingSystem(HttpServletRequest request) {
        UserAgent userAgent = getUserAgent(request);
        return null != userAgent ? userAgent.getOperatingSystem() : null;
    }

    private static UserAgent getUserAgent(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        return null != ua ? UserAgent.parseUserAgentString(ua) : null;
    }

    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress)) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException var4) {
                    var4.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }

        if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        if ("0:0:0:0:0:0:0:1".equals(ipAddress) || ipAddress == null || "".equals(ipAddress)) {
            ipAddress = "127.0.0.1";
        }

        return ipAddress;
    }
}
