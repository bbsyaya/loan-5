package com.loan.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {
    private static Logger logger = LoggerFactory.getLogger(IPUtil.class);

    /**
    =======
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.net.URL;
    import java.net.URLConnection;
    
    import javax.servlet.http.HttpServletRequest;
    
    import org.apache.commons.lang3.StringUtils;
    
    public class IPUtil {
    
    /**
     * 获取远程机器ip地址
     * 
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
//            //多次反向代理后会有多个ip值，第一个ip才是真实ip
//            int index = ip.indexOf(",");
//            if (index != -1) {
//                return ip.substring(0, index);
//            } else {
//                return ip;
//            }
//        }
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr();
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        logger.info("getIpAddress ip1={}", ip);
        if (StringUtils.isBlank(ip) || ip.startsWith("172.") || ip.startsWith("192.168") || ip.startsWith("10.")) {
            ip = getRemoteIp(request);
        }
        logger.info("getIpAddress ip2={}", ip);
        if (StringUtils.isBlank(ip) || ip.startsWith("172.") || ip.startsWith("192.168") || ip.startsWith("10.")) {
            //  if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }
        int index = ip.indexOf(",");
        if (index != -1) {
            ip = ip.substring(0, index);
        }
        return ip;
    }

    /**
     * @Description: 判断ip是否在ip段内
     * @param ipSection  ip段 eg:192.168.1.1-192.168.1.34
     * @param ip  192.168.1.21
     * @return
     * @author: yqx 
     * @date: 2016年9月9日 下午6:10:09
     */
    public static boolean ipIsValid(String ipSection, String ip) {
        if (ipSection == null)
            throw new NullPointerException("IP段不能为空！");
        if (ip == null)
            throw new NullPointerException("IP不能为空！");
        ipSection = ipSection.trim();
        ip = ip.trim();
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
            return false;
        int idx = ipSection.indexOf('-');
        String[] sips = ipSection.substring(0, idx).split("\\.");
        String[] sipe = ipSection.substring(idx + 1).split("\\.");
        String[] sipt = ip.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(sips[i]);
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }

}
