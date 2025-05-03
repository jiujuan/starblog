package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.Comment;
import com.starblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论控制器
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     */
    @PostMapping
    public Result<Boolean> addComment(@RequestBody Comment comment) {
        boolean success = commentService.addComment(comment);
        return success ? Result.success(true) : Result.fail("添加评论失败");
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteComment(@PathVariable Long id) {
        boolean success = commentService.deleteComment(id);
        return success ? Result.success(true) : Result.fail("删除评论失败");
    }

    /**
     * 更新评论
     */
    @PutMapping
    public Result<Boolean> updateComment(@RequestBody Comment comment) {
        boolean success = commentService.updateComment(comment);
        return success ? Result.success(true) : Result.fail("更新评论失败");
    }

    /**
     * 根据ID获取评论
     */
    @GetMapping("/{id}")
    public Result<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return comment != null ? Result.success(comment) : Result.fail("评论不存在");
    }

    /**
     * 根据文章ID获取评论
     */
    @GetMapping("/article/{articleId}")
    public Result<List<Comment>> getCommentsByArticleId(@PathVariable Long articleId) {
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        return Result.success(comments);
    }

    /**
     * 根据用户ID获取评论
     */
    @GetMapping("/user/{userId}")
    public Result<List<Comment>> getCommentsByUserId(@PathVariable Long userId) {
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        return Result.success(comments);
    }

    /**
     * 根据父评论ID获取子评论
     */
    @GetMapping("/parent/{parentId}")
    public Result<List<Comment>> getCommentsByParentId(@PathVariable Long parentId) {
        List<Comment> comments = commentService.getCommentsByParentId(parentId);
        return Result.success(comments);
    }

    /**
     * 获取根评论
     */
    @GetMapping("/root")
    public Result<List<Comment>> getRootComments() {
        List<Comment> comments = commentService.getRootComments();
        return Result.success(comments);
    }

    /**
     * 根据文章ID获取根评论
     */
    @GetMapping("/root/article/{articleId}")
    public Result<List<Comment>> getRootCommentsByArticleId(@PathVariable Long articleId) {
        List<Comment> comments = commentService.getRootCommentsByArticleId(articleId);
        return Result.success(comments);
    }

    /**
     * 根据状态获取评论
     */
    @GetMapping("/status/{status}")
    public Result<List<Comment>> getCommentsByStatus(@PathVariable Integer status) {
        List<Comment> comments = commentService.getCommentsByStatus(status);
        return Result.success(comments);
    }

    /**
     * 分页获取评论
     */
    @GetMapping("/page")
    public Result<List<Comment>> getCommentsByPage(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        List<Comment> comments = commentService.getCommentsByPage(page, size);
        return Result.success(comments);
    }

    /**
     * 获取文章评论数
     */
    @GetMapping("/count/article/{articleId}")
    public Result<Long> getCommentCountByArticleId(@PathVariable Long articleId) {
        Long count = commentService.getCommentCountByArticleId(articleId);
        return Result.success(count);
    }

    /**
     * 获取用户评论数
     */
    @GetMapping("/count/user/{userId}")
    public Result<Long> getCommentCountByUserId(@PathVariable Long userId) {
        Long count = commentService.getCommentCountByUserId(userId);
        return Result.success(count);
    }

    /**
     * 获取评论总数
     */
    @GetMapping("/count")
    public Result<Long> getCommentCount() {
        Long count = commentService.getCommentCount();
        return Result.success(count);
    }
}