package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.ArticleLike;
import com.starblog.service.ArticleLikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArticleLikeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ArticleLikeService articleLikeService;

    @InjectMocks
    private ArticleLikeController articleLikeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(articleLikeController).build();
    }

    @Test
    public void testCreateArticleLike() throws Exception {
        ArticleLike articleLike = new ArticleLike();
        articleLike.setId(1L);
        articleLike.setArticleId(1L);
        articleLike.setUserId(1L);
        articleLike.setCreateTime(new Date());

        when(articleLikeService.createArticleLike(any(ArticleLike.class))).thenReturn(articleLike);

        mockMvc.perform(post("/api/article-likes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"articleId\":1,\"userId\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.articleId").value(1))
                .andExpect(jsonPath("$.data.userId").value(1));
    }

    @Test
    public void testDeleteArticleLike() throws Exception {
        when(articleLikeService.deleteArticleLike(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/api/article-likes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").value(true));
    }

    @Test
    public void testGetArticleLikeById() throws Exception {
        ArticleLike articleLike = new ArticleLike();
        articleLike.setId(1L);
        articleLike.setArticleId(1L);
        articleLike.setUserId(1L);
        articleLike.setCreateTime(new Date());

        when(articleLikeService.getArticleLikeById(anyLong())).thenReturn(articleLike);

        mockMvc.perform(get("/api/article-likes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.articleId").value(1))
                .andExpect(jsonPath("$.data.userId").value(1));
    }

    @Test
    public void testGetArticleLikesByArticleId() throws Exception {
        List<ArticleLike> articleLikes = new ArrayList<>();
        ArticleLike articleLike = new ArticleLike();
        articleLike.setId(1L);
        articleLike.setArticleId(1L);
        articleLike.setUserId(1L);
        articleLike.setCreateTime(new Date());
        articleLikes.add(articleLike);

        when(articleLikeService.getArticleLikesByArticleId(anyLong())).thenReturn(articleLikes);

        mockMvc.perform(get("/api/article-likes/article/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].articleId").value(1))
                .andExpect(jsonPath("$.data[0].userId").value(1));
    }
}