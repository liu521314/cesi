package com.fh.shop.util.cookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Liu
 * @Date: 2019/7/17 21:53
 * @Description:
 */
public class CookieUtil {

    public static String readCookie(HttpServletRequest request, String code){
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(code)){
                cookieValue = cookie.getValue();
            }
        }
        return cookieValue;
    }

    /**
     * 保存Cookies
     *
     * @param response
     *            servlet请求
     * @param value
     *            保存值
     * @author jxf
     */
    public static HttpServletResponse writeCookie(HttpServletResponse response, String name, String value, String Domain) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(Domain);
        // tomcat下多应用共享
        cookie.setPath("/");
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 将Cookie添加到Response中,使之生效
        response.addCookie(cookie);
        return response;
    }


    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

}
