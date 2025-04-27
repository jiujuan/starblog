package com.starblog.common;

/**
 * 响应状态码枚举类
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "没有相关权限"),
    NOT_FOUND(404, "资源不存在"),
    
    // 用户相关错误
    USER_NOT_EXIST(1001, "用户不存在"),
    USER_LOGIN_FAILED(1002, "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN(1003, "用户账号已被禁用"),
    USER_ACCOUNT_EXISTED(1004, "用户账号已存在"),
    
    // 文章相关错误
    ARTICLE_NOT_EXIST(2001, "文章不存在"),
    ARTICLE_CATEGORY_NOT_EXIST(2002, "文章分类不存在"),
    
    // 评论相关错误
    COMMENT_NOT_EXIST(3001, "评论不存在"),
    
    // 系统相关错误
    SYSTEM_ERROR(9001, "系统错误"),
    SYSTEM_BUSY(9002, "系统繁忙");
    
    private Integer code;
    private String message;
    
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
}