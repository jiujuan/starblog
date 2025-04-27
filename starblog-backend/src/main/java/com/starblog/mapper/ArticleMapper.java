package com.starblog.mapper;

import com.starblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    
    // 插入文章
    int insert(Article article);
    
    // 根据ID删除文章
    int deleteById(Long id);
    
    // 更新文章
    int update(Article article);
    
    // 根据ID查询文章
    Article selectById(Long id);
    
    // 查询所有文章
    List<Article> selectAll();
    
    // 根据条件查询文章列表
    List<Article> selectByCondition(Article article);
    
    // 根据分类ID查询文章列表
    List<Article> selectByCategoryId(Long categoryId);
    
    // 根据用户ID查询文章列表
    List<Article> selectByUserId(Long userId);
    
    // 增加文章浏览量
    int incrementViewCount(Long id);
    
    // 增加文章点赞数
    int incrementLikeCount(Long id);
    
    // 增加文章评论数
    int incrementCommentCount(Long id);
    
    // 减少文章点赞数
    int decrementLikeCount(Long id);
    
    // 减少文章评论数
    int decrementCommentCount(Long id);
    
    // 统计文章总数
    Long countAll();
    
    // 根据条件统计文章数量
    Long countByCondition(Article article);
    
    // 分页查询文章
    List<Article> selectByPage(@Param("offset") int offset, @Param("limit") int limit);
}