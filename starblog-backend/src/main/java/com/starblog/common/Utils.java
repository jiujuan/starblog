package com.starblog.common;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 通用工具类
 */
public class Utils {
    /**
     * 邮箱正则表达式
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    
    /**
     * 手机号正则表达式
     */
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3-9]\\d{9}$");
    
    /**
     * 检查字符串是否为空
     *
     * @param str 待检查字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }
    
    /**
     * 检查字符串是否不为空
     *
     * @param str 待检查字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }
    
    /**
     * 检查字符串是否为空白
     *
     * @param str 待检查字符串
     * @return 是否为空白
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }
    
    /**
     * 检查字符串是否不为空白
     *
     * @param str 待检查字符串
     * @return 是否不为空白
     */
    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }
    
    /**
     * 生成UUID
     *
     * @return UUID字符串
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    /**
     * 格式化日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    /**
     * 检查是否为有效的邮箱地址
     *
     * @param email 邮箱地址
     * @return 是否有效
     */
    public static boolean isValidEmail(String email) {
        if (isBlank(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * 检查是否为有效的手机号
     *
     * @param mobile 手机号
     * @return 是否有效
     */
    public static boolean isValidMobile(String mobile) {
        if (isBlank(mobile)) {
            return false;
        }
        return MOBILE_PATTERN.matcher(mobile).matches();
    }
    
    /**
     * 截取字符串
     *
     * @param str   原字符串
     * @param limit 长度限制
     * @return 截取后的字符串
     */
    public static String truncate(String str, int limit) {
        if (isBlank(str)) {
            return str;
        }
        if (str.length() <= limit) {
            return str;
        }
        return str.substring(0, limit) + "...";
    }
}