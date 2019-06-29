package com.wh.utils;


import com.wh.toos.StaticVariable;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.wh.toos.Constants;

import java.security.MessageDigest;

/**
 * MD5加盐
 *
 * @author Administrator
 */
public class MD5Util {

    /**
     * shiro 盐值加密
     *
     * @param uName
     * @param pwd
     * @return
     */
    public static String saltMd5(String uName, String pwd) {
        ByteSource salt = ByteSource.Util.bytes(uName);
        Object result = new SimpleHash("MD5", pwd, salt, 1024);
        return result.toString();
    }

    /**
     * md5常用工具类
     *
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //C82BB40E3E1C6D1E880645353F6F53B8
        String v = StaticVariable.ADMIN + 1 + "tt";
        System.out.println(MD5Util.MD5(v));
        //盐值加密
//        ByteSource salt = ByteSource.Util.bytes("dd");
//        Object result = new SimpleHash("MD5", "1", salt, 1024);
//        //d6f1c053e0a3faca08830aabca5f9885
//        System.out.println(result);
    }
}  
