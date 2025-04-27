package com.starblog.service.impl;

import com.starblog.entity.ArticleLike;
import com.starblog.mapper.ArticleLikeMapper;
import com.starblog.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 文章点赞服务实现类
 */
@Service
public class ArticleLikeServiceImpl implements ArticleLikeService {

    @Autowired
    private ArticleLikeMapper articleLikeMapper;
    
    @Override
    @Transactional
    public ArticleLike createArticleLike(ArticleLike articleLike) {
        // 设置创建时间
        articleLike.setCreateTime(new Date());
        
        // 插入点赞记录
        articleLikeMapper.insert(articleLike);
        return articleLike;
    }
    
    @Override
    @Transactional
    public boolean deleteArticleLike(Long id) {
        return articleLikeMapper.deleteById(id) > 0;
    }
    
    @Override
    @Transactional
    public boolean deleteArticleLikeByArticleIdAndUserId(Long articleId, Long userId) {
        return articleLikeMapper.deleteByArticleIdAndUserId(articleId, userId) > 0;
    }
    
    @Override
    public ArticleLike getArticleLikeById(Long id) {
        return articleLikeMapper.selectById(id);
    }
    
    @Override
    public List<ArticleLike> getArticleLikesByArticleId(Long articleId) {
        return articleLikeMapper.selectByArticleId(articleId);
    }
    
    @Override
    public List<ArticleLike> getArticleLikesByUserId(Long userId) {
        return articleLikeMapper.selectByUserId(userId);
    }
    
    @Override
    public ArticleLike getArticleLikeByArticleIdAndUserId(Long articleId, Long userId) {
        return articleLikeMapper.selectByArticleIdAndUserId(articleId, userId);
    }
    
    @Override
    public Long getArticleLikeCountByArticleId(Long articleId) {
        return articleLikeMapper.countByArticleId(articleId);
    }
    
    @Override
    public Long getArticleLikeCountByUserId(Long userId) {
        return articleLikeMapper.countByUserId(userId);
    }
}