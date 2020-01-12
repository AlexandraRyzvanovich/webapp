package com.epam.webapp;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Apache {
    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
