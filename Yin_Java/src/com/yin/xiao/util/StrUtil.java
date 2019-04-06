package com.yin.xiao.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by suchengjian on 2019/4/3
 * Email: 13282221172@163.com
 */
public class StrUtil {
    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();//java.security.SecureRandom

    public static String generateNonceStr() {

        char[] nonceChars = new char[32];

        for (int index = 0; index < nonceChars.length; ++index) {

            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
