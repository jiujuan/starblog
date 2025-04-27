package com.starblog.controller;

import com.starblog.common.PageResult;
import com.starblog.common.Result;
import com.starblog.entity.Article;
import com.starblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章控制器
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章
     */
    @PostMapping
    public Result<Boolean> addArticle(@RequestBody Article article) {
        boolean success = articleService.addArticle(article);
        return success ? Result.success(true) : Result.fail("添加文章失败");
    }

    /**
     * 删除文章
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteArticle(@PathVariable Long id) {
        boolean success = articleService.deleteArticle(id);
        return success ? Result.success(true) : Result.fail("删除文章失败");
    }

    /**
     * 更新文章
     */
    @PutMapping
    public Result<Boolean> updateArticle(@RequestBody Article article) {
        boolean success = articleService.updateArticle(article);
        return success ? Result.success(true) : Result.fail("更新文章失败");
    }

    /**
     * 根据ID获取文章
     */
    @GetMapping("/{id}")
    public Result<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        return article != null ? Result.success(article) : Result.fail("文章不存在");
    }

    /**
     * 获取所有文章
     */
    @GetMapping
    public Result<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return Result.success(articles);
    }

    /**
     * 根据条件获取文章
     */
    @PostMapping("/condition")
    public Result<List<Article>> getArticlesByCondition(@RequestBody Article article) {
        List<Article> articles = articleService.getArticlesByCondition(article);
        return Result.success(articles);
    }

    /**
     * 根据分类ID获取文章
     */
    @GetMapping("/category/{categoryId}")
    public Result<List<Article>> getArticlesByCategoryId(@PathVariable Long categoryId) {
        List<Article> articles = articleService.getArticlesByCategoryId(categoryId);
        return Result.success(articles);
    }

    /**
     * 根据用户ID获取文章
     */
    @GetMapping("/user/{userId}")
    public Result<List<Article>> getArticlesByUserId(@PathVariable Long userId) {
        List<Article> articles = articleService.getArticlesByUserId(userId);
        return Result.success(articles);
    }

    /**
     * 增加文章浏览量
     */
    @PutMapping("/{id}/view")
    public Result<Boolean> incrementViewCount(@PathVariable Long id) {
        boolean success = articleService.incrementViewCount(id);
        return success ? Result.success(true) : Result.fail("增加浏览量失败");
    }

    /**
     * 增加文章点赞量
     */
    @PutMapping("/{id}/like")
    public Result<Boolean> incrementLikeCount(@PathVariable Long id) {
        boolean success = articleService.incrementLikeCount(id);
        return success ? Result.success(true) : Result.fail("增加点赞量失败");
    }

    /**
     * 减少文章点赞量
     */
    @PutMapping("/{id}/unlike")
    public Result<Boolean> decrementLikeCount(@PathVariable Long id) {
        boolean success = articleService.decrementLikeCount(id);
        return success ? Result.success(true) : Result.fail("减少点赞量失败");
    }

    /**
     * 分页获取文章
     */
    @GetMapping("/page")
    public Result<PageResult<Article>> getArticlesByPage(@RequestParam(defaultValue = "1") int pageNum,
                                                       @RequestParam(defaultValue = "10") int pageSize) {
        PageResult<Article> pageResult = articleService.getArticlesByPage(pageNum, pageSize);
        return Result.success(pageResult);
    }
}