package com.sedion.mynawang.common.core.util;

/**
 * 字符串工具类
 * @auther mynawang
 * @create 2016-09-29 21:50
 */
public class StringUtil {
    /**
     * 判断给定字符串是否空白串。
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串
     * 若输入字符串为null或空字符串，返回true
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input){
        if (input == null || input.trim().equals("")){
            return true;
        }
        return false;
    }

}
