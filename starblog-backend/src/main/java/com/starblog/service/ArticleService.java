package com.starblog.service;

import com.starblog.common.PageResult;
import com.starblog.entity.Article;

import java.util.List;

public interface ArticleService {
    
    /**
     * 添加文章
     * @param article 文章
     * @return 是否成功
     */
    boolean addArticle(Article article);
    
    /**
     * 删除文章
     * @param id 文章ID
     * @return 是否成功
     */
    boolean deleteArticle(Long id);
    
    /**
     * 更新文章
     * @param article 文章
     * @return 是否成功
     */
    boolean updateArticle(Article article);
    
    /**
     * 根据ID获取文章
     * @param id 文章ID
     * @return 文章
     */
    Article getArticleById(Long id);
    
    /**
     * 获取所有文章
     * @return 文章列表
     */
    List<Article> getAllArticles();
    
    /**
     * 根据条件获取文章列表
     * @param article 条件
     * @return 文章列表
     */
    List<Article> getArticlesByCondition(Article article);
    
    /**
     * 根据分类ID获取文章列表
     * @param categoryId 分类ID
     * @return 文章列表
     */
    List<Article> getArticlesByCategoryId(Long categoryId);
    
    /**
     * 根据用户ID获取文章列表
     * @param userId 用户ID
     * @return 文章列表
     */
    List<Article> getArticlesByUserId(Long userId);
    
    /**
     * 增加文章浏览量
     * @param id 文章ID
     * @return 是否成功
     */
    boolean incrementViewCount(Long id);
    
    /**
     * 增加文章点赞数
     * @param id 文章ID
     * @return 是否成功
     */
    boolean incrementLikeCount(Long id);
    
    /**
     * 增加文章评论数
     * @param id 文章ID
     * @return 是否成功
     */
    boolean incrementCommentCount(Long id);
    
    /**
     * 减少文章点赞数
     * @param id 文章ID
     * @return 是否成功
     */
    boolean decrementLikeCount(Long id);
    
    /**
     * 减少文章评论数
     * @param id 文章ID
     * @return 是否成功
     */
    boolean decrementCommentCount(Long id);
    
    /**
     * 分页获取文章列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 分页结果
     */
    PageResult<Article> getArticlesByPage(int pageNum, int pageSize);
}