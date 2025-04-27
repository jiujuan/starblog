package com.starblog.service;

import com.starblog.entity.ArticleTag;

import java.util.List;

public interface ArticleTagService {
    
    /**
     * 添加文章标签关联
     * @param articleTag 文章标签关联
     * @return 是否成功
     */
    boolean addArticleTag(ArticleTag articleTag);
    
    /**
     * 批量添加文章标签关联
     * @param articleTags 文章标签关联列表
     * @return 是否成功
     */
    boolean batchAddArticleTag(List<ArticleTag> articleTags);
    
    /**
     * 删除文章标签关联
     * @param id ID
     * @return 是否成功
     */
    boolean deleteArticleTag(Long id);
    
    /**
     * 根据文章ID删除文章标签关联
     * @param articleId 文章ID
     * @return 是否成功
     */
    boolean deleteByArticleId(Long articleId);
    
    /**
     * 根据标签ID删除文章标签关联
     * @param tagId 标签ID
     * @return 是否成功
     */
    boolean deleteByTagId(Long tagId);
    
    /**
     * 根据文章ID和标签ID删除文章标签关联
     * @param articleId 文章ID
     * @param tagId 标签ID
     * @return 是否成功
     */
    boolean deleteByArticleIdAndTagId(Long articleId, Long tagId);
    
    /**
     * 根据ID获取文章标签关联
     * @param id ID
     * @return 文章标签关联
     */
    ArticleTag getArticleTagById(Long id);
    
    /**
     * 根据文章ID获取文章标签关联列表
     * @param articleId 文章ID
     * @return 文章标签关联列表
     */
    List<ArticleTag> getArticleTagsByArticleId(Long articleId);
    
    /**
     * 根据标签ID获取文章标签关联列表
     * @param tagId 标签ID
     * @return 文章标签关联列表
     */
    List<ArticleTag> getArticleTagsByTagId(Long tagId);
    
    /**
     * 根据文章ID和标签ID获取文章标签关联
     * @param articleId 文章ID
     * @param tagId 标签ID
     * @return 文章标签关联
     */
    ArticleTag getArticleTagByArticleIdAndTagId(Long articleId, Long tagId);
}