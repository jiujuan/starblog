package com.starblog.controller;

import com.starblog.common.Result;
import com.starblog.entity.Category;
import com.starblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类控制器
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加分类
     */
    @PostMapping
    public Result<Boolean> addCategory(@RequestBody Category category) {
        boolean success = categoryService.addCategory(category);
        return success ? Result.success(true) : Result.fail("添加分类失败");
    }

    /**
     * 删除分类
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCategory(@PathVariable Long id) {
        boolean success = categoryService.deleteCategory(id);
        return success ? Result.success(true) : Result.fail("删除分类失败");
    }

    /**
     * 更新分类
     */
    @PutMapping
    public Result<Boolean> updateCategory(@RequestBody Category category) {
        boolean success = categoryService.updateCategory(category);
        return success ? Result.success(true) : Result.fail("更新分类失败");
    }

    /**
     * 根据ID获取分类
     */
    @GetMapping("/{id}")
    public Result<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return category != null ? Result.success(category) : Result.fail("分类不存在");
    }

    /**
     * 根据名称获取分类
     */
    @GetMapping("/name/{name}")
    public Result<Category> getCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        return category != null ? Result.success(category) : Result.fail("分类不存在");
    }

    /**
     * 获取所有分类
     */
    @GetMapping
    public Result<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return Result.success(categories);
    }

    /**
     * 获取分类总数
     */
    @GetMapping("/count")
    public Result<Long> getCategoryCount() {
        Long count = categoryService.getCategoryCount();
        return Result.success(count);
    }
}