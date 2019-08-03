package com.fh.shop.util.joint;

/**
 * @Auther: Liu
 * @Date: 2019/7/18 12:06
 * @Description:
 */
public class Joint {

    public static String codeKey(String uuid){
        return "code:"+ uuid;
    }

    public static String userKey(String toJSONString){
        return "user:"+toJSONString;
    }
}
