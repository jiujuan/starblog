package com.starblog.service.impl;

import com.starblog.common.PageResult;
import com.starblog.entity.Article;
import com.starblog.mapper.ArticleMapper;
import com.starblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean addArticle(Article article) {
        Date now = new Date();
        article.setCreateTime(now);
        article.setUpdateTime(now);
        article.setViewCount(0);
        article.setLikeCount(0);
        article.setCommentCount(0);
        return articleMapper.insert(article) > 0;
    }

    @Override
    public boolean deleteArticle(Long id) {
        return articleMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        article.setUpdateTime(new Date());
        return articleMapper.update(article) > 0;
    }

    @Override
    public Article getArticleById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.selectAll();
    }

    @Override
    public List<Article> getArticlesByCondition(Article article) {
        return articleMapper.selectByCondition(article);
    }

    @Override
    public List<Article> getArticlesByCategoryId(Long categoryId) {
        return articleMapper.selectByCategoryId(categoryId);
    }

    @Override
    public List<Article> getArticlesByUserId(Long userId) {
        return articleMapper.selectByUserId(userId);
    }

    @Override
    public boolean incrementViewCount(Long id) {
        return articleMapper.incrementViewCount(id) > 0;
    }

    @Override
    public boolean incrementLikeCount(Long id) {
        return articleMapper.incrementLikeCount(id) > 0;
    }

    @Override
    public boolean incrementCommentCount(Long id) {
        return articleMapper.incrementCommentCount(id) > 0;
    }

    @Override
    public boolean decrementLikeCount(Long id) {
        return articleMapper.decrementLikeCount(id) > 0;
    }

    @Override
    public boolean decrementCommentCount(Long id) {
        return articleMapper.decrementCommentCount(id) > 0;
    }

    @Override
    public PageResult<Article> getArticlesByPage(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        List<Article> articles = articleMapper.selectByPage(offset, pageSize);
        Long total = articleMapper.countAll();
        return new PageResult<>(articles, total, pageNum, pageSize);
    }
}