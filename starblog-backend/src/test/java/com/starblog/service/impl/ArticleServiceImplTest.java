package com.starblog.service.impl;

import com.starblog.entity.Article;
import com.starblog.mapper.ArticleMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ArticleServiceImplTest {

    @Mock
    private ArticleMapper articleMapper;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddArticle() {
        Article article = new Article();
        article.setTitle("测试文章");
        article.setContent("这是一篇测试文章");
        article.setCategoryId(1L);
        article.setUserId(1L);

        when(articleMapper.insert(any(Article.class))).thenReturn(1);

        boolean result = articleService.addArticle(article);
        assertTrue(result);
        assertNotNull(article.getCreateTime());
        assertNotNull(article.getUpdateTime());
        assertEquals(0, article.getViewCount());
        assertEquals(0, article.getLikeCount());
        assertEquals(0, article.getCommentCount());
    }

    @Test
    public void testGetArticleById() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("测试文章");
        article.setContent("这是一篇测试文章");
        article.setCategoryId(1L);
        article.setUserId(1L);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setViewCount(10);
        article.setLikeCount(5);
        article.setCommentCount(3);

        when(articleMapper.selectById(anyLong())).thenReturn(article);

        Article result = articleService.getArticleById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("测试文章", result.getTitle());
        assertEquals(10, result.getViewCount());
        assertEquals(5, result.getLikeCount());
        assertEquals(3, result.getCommentCount());
    }

    @Test
    public void testGetAllArticles() {
        List<Article> articles = new ArrayList<>();
        Article article1 = new Article();
        article1.setId(1L);
        article1.setTitle("测试文章1");
        articles.add(article1);

        Article article2 = new Article();
        article2.setId(2L);
        article2.setTitle("测试文章2");
        articles.add(article2);

        when(articleMapper.selectAll()).thenReturn(articles);

        List<Article> result = articleService.getAllArticles();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("测试文章1", result.get(0).getTitle());
        assertEquals("测试文章2", result.get(1).getTitle());
    }

    @Test
    public void testIncrementViewCount() {
        when(articleMapper.incrementViewCount(anyLong())).thenReturn(1);

        boolean result = articleService.incrementViewCount(1L);
        assertTrue(result);
    }

    @Test
    public void testIncrementLikeCount() {
        when(articleMapper.incrementLikeCount(anyLong())).thenReturn(1);

        boolean result = articleService.incrementLikeCount(1L);
        assertTrue(result);
    }
}