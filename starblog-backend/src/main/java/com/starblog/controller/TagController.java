package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.Tag;
import com.starblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制器
 */
@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 添加标签
     */
    @PostMapping
    public Result<Boolean> addTag(@RequestBody Tag tag) {
        boolean success = tagService.addTag(tag);
        return success ? Result.success(true) : Result.fail("添加标签失败");
    }

    /**
     * 删除标签
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteTag(@PathVariable Long id) {
        boolean success = tagService.deleteTag(id);
        return success ? Result.success(true) : Result.fail("删除标签失败");
    }

    /**
     * 更新标签
     */
    @PutMapping
    public Result<Boolean> updateTag(@RequestBody Tag tag) {
        boolean success = tagService.updateTag(tag);
        return success ? Result.success(true) : Result.fail("更新标签失败");
    }

    /**
     * 根据ID获取标签
     */
    @GetMapping("/{id}")
    public Result<Tag> getTagById(@PathVariable Long id) {
        Tag tag = tagService.getTagById(id);
        return tag != null ? Result.success(tag) : Result.fail("标签不存在");
    }

    /**
     * 根据名称获取标签
     */
    @GetMapping("/name/{name}")
    public Result<Tag> getTagByName(@PathVariable String name) {
        Tag tag = tagService.getTagByName(name);
        return tag != null ? Result.success(tag) : Result.fail("标签不存在");
    }

    /**
     * 获取所有标签
     */
    @GetMapping
    public Result<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return Result.success(tags);
    }

    /**
     * 根据文章ID获取标签列表
     */
    @GetMapping("/article/{articleId}")
    public Result<List<Tag>> getTagsByArticleId(@PathVariable Long articleId) {
        List<Tag> tags = tagService.getTagsByArticleId(articleId);
        return Result.success(tags);
    }

    /**
     * 获取标签总数
     */
    @GetMapping("/count")
    public Result<Long> getTagCount() {
        Long count = tagService.getTagCount();
        return Result.success(count);
    }
}