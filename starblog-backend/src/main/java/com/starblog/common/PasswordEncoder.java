package com.starblog.common;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 密码编码器，用于密码的加密和验证
 */
@Component
public class PasswordEncoder {

    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 16;

    /**
     * 生成随机盐
     *
     * @return 盐（Base64编码）
     */
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * 使用指定的盐对密码进行加密
     *
     * @param password 原始密码
     * @param salt     盐（Base64编码）
     * @return 加密后的密码（Base64编码）
     */
    public String encode(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密算法不可用", e);
        }
    }

    /**
     * 对密码进行加密（自动生成盐）
     *
     * @param password 原始密码
     * @return 格式为"加密后的密码$盐"的字符串
     */
    public String encode(String password) {
        String salt = generateSalt();
        String encodedPassword = encode(password, salt);
        return encodedPassword + "$" + salt;
    }

    /**
     * 验证密码是否匹配
     *
     * @param rawPassword     原始密码
     * @param encodedPassword 已加密的密码（格式为"加密后的密码$盐"）
     * @return 是否匹配
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        String[] parts = encodedPassword.split("\\$");
        if (parts.length != 2) {
            return false;
        }
        
        String hashedPassword = parts[0];
        String salt = parts[1];
        
        String checkPassword = encode(rawPassword, salt);
        return checkPassword.equals(hashedPassword);
    }
}