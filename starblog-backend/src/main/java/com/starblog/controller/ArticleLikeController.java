package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.ArticleLike;
import com.starblog.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章点赞控制器
 */
@RestController
@RequestMapping("/api/article-likes")
public class ArticleLikeController {

    @Autowired
    private ArticleLikeService articleLikeService;

    /**
     * 创建文章点赞
     */
    @PostMapping
    public Result<ArticleLike> createArticleLike(@RequestBody ArticleLike articleLike) {
        boolean success = articleLikeService.addArticleLike(articleLike);
        return success ? Result.success(articleLike) : Result.fail("创建点赞失败");
    }

    /**
     * 删除文章点赞
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteArticleLike(@PathVariable Long id) {
        boolean success = articleLikeService.deleteArticleLike(id);
        return success ? Result.success(true) : Result.fail("删除点赞失败");
    }

    /**
     * 根据文章ID和用户ID删除点赞
     */
    @DeleteMapping("/article/{articleId}/user/{userId}")
    public Result<Boolean> deleteArticleLikeByArticleIdAndUserId(@PathVariable Long articleId, @PathVariable Long userId) {
        boolean success = articleLikeService.deleteArticleLikeByArticleIdAndUserId(articleId, userId);
        return success ? Result.success(true) : Result.fail("删除点赞失败");
    }

    /**
     * 根据ID获取点赞
     */
    @GetMapping("/{id}")
    public Result<ArticleLike> getArticleLikeById(@PathVariable Long id) {
        ArticleLike articleLike = articleLikeService.getArticleLikeById(id);
        return articleLike != null ? Result.success(articleLike) : Result.fail("点赞不存在");
    }

    /**
     * 根据文章ID获取点赞列表
     */
    @GetMapping("/article/{articleId}")
    public Result<List<ArticleLike>> getArticleLikesByArticleId(@PathVariable Long articleId) {
        List<ArticleLike> articleLikes = articleLikeService.getArticleLikesByArticleId(articleId);
        return Result.success(articleLikes);
    }

    /**
     * 根据用户ID获取点赞列表
     */
    @GetMapping("/user/{userId}")
    public Result<List<ArticleLike>> getArticleLikesByUserId(@PathVariable Long userId) {
        List<ArticleLike> articleLikes = articleLikeService.getArticleLikesByUserId(userId);
        return Result.success(articleLikes);
    }

    /**
     * 根据文章ID和用户ID获取点赞
     */
    @GetMapping("/article/{articleId}/user/{userId}")
    public Result<ArticleLike> getArticleLikeByArticleIdAndUserId(@PathVariable Long articleId, @PathVariable Long userId) {
        ArticleLike articleLike = articleLikeService.getArticleLikeByArticleIdAndUserId(articleId, userId);
        return articleLike != null ? Result.success(articleLike) : Result.fail("点赞不存在");
    }

    /**
     * 获取文章点赞数
     */
    @GetMapping("/count/article/{articleId}")
    public Result<Long> getArticleLikeCountByArticleId(@PathVariable Long articleId) {
        Long count = articleLikeService.getArticleLikeCountByArticleId(articleId);
        return Result.success(count);
    }

    /**
     * 获取用户点赞数
     */
    @GetMapping("/count/user/{userId}")
    public Result<Long> getArticleLikeCountByUserId(@PathVariable Long userId) {
        Long count = articleLikeService.getArticleLikeCountByUserId(userId);
        return Result.success(count);
    }
    
    /**
     * 检查用户是否点赞了文章
     */
    @GetMapping("/check/article/{articleId}/user/{userId}")
    public Result<Boolean> isArticleLikedByUser(@PathVariable Long articleId, @PathVariable Long userId) {
        boolean liked = articleLikeService.isArticleLikedByUser(articleId, userId);
        return Result.success(liked);
    }
}