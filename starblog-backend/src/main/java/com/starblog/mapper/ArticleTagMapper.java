package com.starblog.mapper;

import com.starblog.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleTagMapper {
    
    // 插入文章标签关联
    int insert(ArticleTag articleTag);
    
    // 批量插入文章标签关联
    int batchInsert(List<ArticleTag> articleTags);
    
    // 根据ID删除文章标签关联
    int deleteById(Long id);
    
    // 根据文章ID删除文章标签关联
    int deleteByArticleId(Long articleId);
    
    // 根据标签ID删除文章标签关联
    int deleteByTagId(Long tagId);
    
    // 根据文章ID和标签ID删除文章标签关联
    int deleteByArticleIdAndTagId(@Param("articleId") Long articleId, @Param("tagId") Long tagId);
    
    // 根据ID查询文章标签关联
    ArticleTag selectById(Long id);
    
    // 根据文章ID查询文章标签关联
    List<ArticleTag> selectByArticleId(Long articleId);
    
    // 根据标签ID查询文章标签关联
    List<ArticleTag> selectByTagId(Long tagId);
    
    // 根据文章ID和标签ID查询文章标签关联
    ArticleTag selectByArticleIdAndTagId(@Param("articleId") Long articleId, @Param("tagId") Long tagId);
}