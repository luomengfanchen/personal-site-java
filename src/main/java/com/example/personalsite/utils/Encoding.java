package com.example.personalsite.utils;

import org.springframework.util.DigestUtils;

public class Encoding {

    /**
     * MD5加密
     * @param param
     * @return
     */
    public static String Md5(String param) {

        byte[] binaryData = param.getBytes();

        return DigestUtils.md5DigestAsHex(binaryData);
    }
}
