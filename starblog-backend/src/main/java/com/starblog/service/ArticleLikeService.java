package com.starblog.service;

import com.starblog.entity.ArticleLike;
import java.util.List;

/**
 * 文章点赞服务接口
 */
public interface ArticleLikeService {
    
    /**
     * 创建点赞记录
     * @param articleLike 点赞记录对象
     * @return 创建的点赞记录对象
     */
    ArticleLike createArticleLike(ArticleLike articleLike);
    
    /**
     * 删除点赞记录
     * @param id 点赞记录ID
     * @return 是否删除成功
     */
    boolean deleteArticleLike(Long id);
    
    /**
     * 根据文章ID和用户ID删除点赞记录
     * @param articleId 文章ID
     * @param userId 用户ID
     * @return 是否删除成功
     */
    boolean deleteArticleLikeByArticleIdAndUserId(Long articleId, Long userId);
    
    /**
     * 根据ID获取点赞记录
     * @param id 点赞记录ID
     * @return 点赞记录对象
     */
    ArticleLike getArticleLikeById(Long id);
    
    /**
     * 根据文章ID获取点赞记录列表
     * @param articleId 文章ID
     * @return 点赞记录列表
     */
    List<ArticleLike> getArticleLikesByArticleId(Long articleId);
    
    /**
     * 根据用户ID获取点赞记录列表
     * @param userId 用户ID
     * @return 点赞记录列表
     */
    List<ArticleLike> getArticleLikesByUserId(Long userId);
    
    /**
     * 根据文章ID和用户ID获取点赞记录
     * @param articleId 文章ID
     * @param userId 用户ID
     * @return 点赞记录对象
     */
    ArticleLike getArticleLikeByArticleIdAndUserId(Long articleId, Long userId);
    
    /**
     * 获取文章点赞数
     * @param articleId 文章ID
     * @return 点赞数
     */
    Long getArticleLikeCountByArticleId(Long articleId);
    
    /**
     * 获取用户点赞数
     * @param userId 用户ID
     * @return 点赞数
     */
    Long getArticleLikeCountByUserId(Long userId);
}