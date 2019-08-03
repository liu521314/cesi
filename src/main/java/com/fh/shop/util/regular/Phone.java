package com.fh.shop.util.regular;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Liu
 * @Date: 2019/7/13 11:10
 * @Description:
 */
public class Phone {
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9])|(19[0-9]))\\d{8}$";// 验证手机号
        if(StringUtils.isNotBlank(str)){
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        return b;

    }

}
