package com.starblog.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * JWT工具类，用于生成和验证JWT令牌
 */
@Component
public class JwtUtil {

    // 密钥
    @Value("${jwt.secret:starblog}")
    private String secret;

    // 过期时间（默认24小时）
    @Value("${jwt.expiration:86400000}")
    private long expiration;

    // 记住我的过期时间（默认7天）
    @Value("${jwt.remember-me-expiration:604800000}")
    private long rememberMeExpiration;

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * 从令牌中获取过期时间
     *
     * @param token 令牌
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * 从令牌中获取指定的声明
     *
     * @param token          令牌
     * @param claimsResolver 声明解析器
     * @param <T>            声明类型
     * @return 声明
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 从令牌中获取所有声明
     *
     * @param token 令牌
     * @return 所有声明
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 检查令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 生成令牌
     *
     * @param username   用户名
     * @param rememberMe 是否记住我
     * @return 令牌
     */
    public String generateToken(String username, Boolean rememberMe) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username, rememberMe);
    }

    /**
     * 生成令牌
     *
     * @param claims     声明
     * @param subject    主题
     * @param rememberMe 是否记住我
     * @return 令牌
     */
    private String doGenerateToken(Map<String, Object> claims, String subject, Boolean rememberMe) {
        long tokenExpiration = rememberMe != null && rememberMe ? rememberMeExpiration : expiration;
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 验证令牌
     *
     * @param token    令牌
     * @param username 用户名
     * @return 是否有效
     */
    public Boolean validateToken(String token, String username) {
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }
}