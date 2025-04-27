package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.ArticleTag;
import com.starblog.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章标签关联控制器
 */
@RestController
@RequestMapping("/api/article-tags")
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 添加文章标签关联
     */
    @PostMapping
    public Result<Boolean> addArticleTag(@RequestBody ArticleTag articleTag) {
        boolean success = articleTagService.addArticleTag(articleTag);
        return success ? Result.success(true) : Result.fail("添加文章标签关联失败");
    }

    /**
     * 批量添加文章标签关联
     */
    @PostMapping("/batch")
    public Result<Boolean> batchAddArticleTag(@RequestBody List<ArticleTag> articleTags) {
        boolean success = articleTagService.batchAddArticleTag(articleTags);
        return success ? Result.success(true) : Result.fail("批量添加文章标签关联失败");
    }

    /**
     * 删除文章标签关联
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteArticleTag(@PathVariable Long id) {
        boolean success = articleTagService.deleteArticleTag(id);
        return success ? Result.success(true) : Result.fail("删除文章标签关联失败");
    }

    /**
     * 根据文章ID删除文章标签关联
     */
    @DeleteMapping("/article/{articleId}")
    public Result<Boolean> deleteByArticleId(@PathVariable Long articleId) {
        boolean success = articleTagService.deleteByArticleId(articleId);
        return success ? Result.success(true) : Result.fail("删除文章标签关联失败");
    }

    /**
     * 根据标签ID删除文章标签关联
     */
    @DeleteMapping("/tag/{tagId}")
    public Result<Boolean> deleteByTagId(@PathVariable Long tagId) {
        boolean success = articleTagService.deleteByTagId(tagId);
        return success ? Result.success(true) : Result.fail("删除文章标签关联失败");
    }

    /**
     * 根据文章ID和标签ID删除文章标签关联
     */
    @DeleteMapping("/article/{articleId}/tag/{tagId}")
    public Result<Boolean> deleteByArticleIdAndTagId(@PathVariable Long articleId, @PathVariable Long tagId) {
        boolean success = articleTagService.deleteByArticleIdAndTagId(articleId, tagId);
        return success ? Result.success(true) : Result.fail("删除文章标签关联失败");
    }

    /**
     * 根据ID获取文章标签关联
     */
    @GetMapping("/{id}")
    public Result<ArticleTag> getArticleTagById(@PathVariable Long id) {
        ArticleTag articleTag = articleTagService.getArticleTagById(id);
        return articleTag != null ? Result.success(articleTag) : Result.fail("文章标签关联不存在");
    }

    /**
     * 根据文章ID获取文章标签关联
     */
    @GetMapping("/article/{articleId}")
    public Result<List<ArticleTag>> getArticleTagsByArticleId(@PathVariable Long articleId) {
        List<ArticleTag> articleTags = articleTagService.getArticleTagsByArticleId(articleId);
        return Result.success(articleTags);
    }

    /**
     * 根据标签ID获取文章标签关联
     */
    @GetMapping("/tag/{tagId}")
    public Result<List<ArticleTag>> getArticleTagsByTagId(@PathVariable Long tagId) {
        List<ArticleTag> articleTags = articleTagService.getArticleTagsByTagId(tagId);
        return Result.success(articleTags);
    }

    /**
     * 根据文章ID和标签ID获取文章标签关联
     */
    @GetMapping("/article/{articleId}/tag/{tagId}")
    public Result<ArticleTag> getArticleTagByArticleIdAndTagId(@PathVariable Long articleId, @PathVariable Long tagId) {
        ArticleTag articleTag = articleTagService.getArticleTagByArticleIdAndTagId(articleId, tagId);
        return articleTag != null ? Result.success(articleTag) : Result.fail("文章标签关联不存在");
    }
}