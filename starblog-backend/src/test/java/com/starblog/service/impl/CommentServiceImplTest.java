package com.starblog.service.impl;

import com.starblog.entity.Comment;
import com.starblog.mapper.CommentMapper;
import com.starblog.service.ArticleService;
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

public class CommentServiceImplTest {

    @Mock
    private CommentMapper commentMapper;

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddComment() {
        Comment comment = new Comment();
        comment.setContent("测试评论");
        comment.setArticleId(1L);
        comment.setUserId(1L);

        when(commentMapper.insert(any(Comment.class))).thenReturn(1);
        when(articleService.incrementCommentCount(anyLong())).thenReturn(true);

        boolean result = commentService.addComment(comment);
        assertTrue(result);
        assertNotNull(comment.getCreateTime());
        assertNotNull(comment.getUpdateTime());
    }

    @Test
    public void testGetCommentById() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setContent("测试评论");
        comment.setArticleId(1L);
        comment.setUserId(1L);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());

        when(commentMapper.selectById(anyLong())).thenReturn(comment);

        Comment result = commentService.getCommentById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("测试评论", result.getContent());
        assertEquals(1L, result.getArticleId());
        assertEquals(1L, result.getUserId());
    }

    @Test
    public void testGetCommentsByArticleId() {
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setContent("测试评论1");
        comment1.setArticleId(1L);
        comments.add(comment1);

        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setContent("测试评论2");
        comment2.setArticleId(1L);
        comments.add(comment2);

        when(commentMapper.selectByArticleId(anyLong())).thenReturn(comments);

        List<Comment> result = commentService.getCommentsByArticleId(1L);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("测试评论1", result.get(0).getContent());
        assertEquals("测试评论2", result.get(1).getContent());
    }

    @Test
    public void testDeleteComment() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setArticleId(1L);

        when(commentMapper.selectById(anyLong())).thenReturn(comment);
        when(commentMapper.deleteById(anyLong())).thenReturn(1);
        when(articleService.decrementCommentCount(anyLong())).thenReturn(true);

        boolean result = commentService.deleteComment(1L);
        assertTrue(result);
    }
}