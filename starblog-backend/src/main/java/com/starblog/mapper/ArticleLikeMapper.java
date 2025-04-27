package com.starblog.mapper;

import com.starblog.entity.ArticleLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleLikeMapper {
    
    // 插入文章点赞记录
    int insert(ArticleLike articleLike);
    
    // 根据ID删除点赞记录
    int deleteById(Long id);
    
    // 根据文章ID和用户ID删除点赞记录
    int deleteByArticleIdAndUserId(@Param("articleId") Long articleId, @Param("userId") Long userId);
    
    // 根据ID查询点赞记录
    ArticleLike selectById(Long id);
    
    // 根据文章ID查询点赞记录
    List<ArticleLike> selectByArticleId(Long articleId);
    
    // 根据用户ID查询点赞记录
    List<ArticleLike> selectByUserId(Long userId);
    
    // 根据文章ID和用户ID查询点赞记录
    ArticleLike selectByArticleIdAndUserId(@Param("articleId") Long articleId, @Param("userId") Long userId);
    
    // 统计文章点赞数
    Long countByArticleId(Long articleId);
    
    // 统计用户点赞数
    Long countByUserId(Long userId);
}