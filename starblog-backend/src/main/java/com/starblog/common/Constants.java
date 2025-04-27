package com.starblog.common;

/**
 * 系统常量类
 */
public class Constants {
    /**
     * 用户状态：正常
     */
    public static final int USER_STATUS_NORMAL = 1;
    
    /**
     * 用户状态：禁用
     */
    public static final int USER_STATUS_DISABLED = 0;
    
    /**
     * 文章状态：草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 0;
    
    /**
     * 文章状态：已发布
     */
    public static final int ARTICLE_STATUS_PUBLISHED = 1;
    
    /**
     * 评论状态：待审核
     */
    public static final int COMMENT_STATUS_PENDING = 0;
    
    /**
     * 评论状态：已通过
     */
    public static final int COMMENT_STATUS_APPROVED = 1;
    
    /**
     * 评论状态：已拒绝
     */
    public static final int COMMENT_STATUS_REJECTED = 2;
    
    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "/images/avatar/default.png";
    
    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    /**
     * 默认分页页码
     */
    public static final int DEFAULT_PAGE_NUM = 1;
    
    /**
     * 用户角色：管理员
     */
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    
    /**
     * 用户角色：普通用户
     */
    public static final String ROLE_USER = "ROLE_USER";
}