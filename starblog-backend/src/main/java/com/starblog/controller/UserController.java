package com.starblog.controller;

import com.starblog.common.PageResult;
import com.starblog.common.Result;
import com.starblog.entity.User;
import com.starblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody User user) {
        boolean success = userService.register(user);
        if (success) {
            return Result.success(true);
        } else {
            return Result.fail("注册失败，用户名或邮箱已存在");
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.fail("登录失败，用户名或密码错误");
        }
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        return success ? Result.success(true) : Result.fail("删除用户失败");
    }

    /**
     * 更新用户信息
     */
    @PutMapping
    public Result<Boolean> updateUser(@RequestBody User user) {
        boolean success = userService.updateUser(user);
        return success ? Result.success(true) : Result.fail("更新用户信息失败");
    }

    /**
     * 更新用户状态
     */
    @PutMapping("/{id}/status")
    public Result<Boolean> updateUserStatus(@PathVariable Long id, @RequestParam Integer status) {
        boolean success = userService.updateUserStatus(id, status);
        return success ? Result.success(true) : Result.fail("更新用户状态失败");
    }

    /**
     * 更新用户密码
     */
    @PutMapping("/{id}/password")
    public Result<Boolean> updatePassword(@PathVariable Long id, @RequestParam String password) {
        boolean success = userService.updatePassword(id, password);
        return success ? Result.success(true) : Result.fail("更新密码失败");
    }

    /**
     * 根据ID获取用户
     */
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? Result.success(user) : Result.fail("用户不存在");
    }

    /**
     * 根据用户名获取用户
     */
    @GetMapping("/username/{username}")
    public Result<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return user != null ? Result.success(user) : Result.fail("用户不存在");
    }

    /**
     * 根据邮箱获取用户
     */
    @GetMapping("/email/{email}")
    public Result<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return user != null ? Result.success(user) : Result.fail("用户不存在");
    }

    /**
     * 获取所有用户
     */
    @GetMapping
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return Result.success(users);
    }

    /**
     * 根据角色获取用户
     */
    @GetMapping("/role/{role}")
    public Result<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        return Result.success(users);
    }

    /**
     * 根据状态获取用户
     */
    @GetMapping("/status/{status}")
    public Result<List<User>> getUsersByStatus(@PathVariable Integer status) {
        List<User> users = userService.getUsersByStatus(status);
        return Result.success(users);
    }

    /**
     * 分页获取用户
     */
    @GetMapping("/page")
    public Result<PageResult<User>> getUsersByPage(@RequestParam(defaultValue = "1") int page, 
                                                 @RequestParam(defaultValue = "10") int size) {
        PageResult<User> pageResult = userService.getUsersByPage(page, size);
        return Result.success(pageResult);
    }

    /**
     * 获取用户总数
     */
    @GetMapping("/count")
    public Result<Long> getUserCount() {
        Long count = userService.getUserCount();
        return Result.success(count);
    }

    /**
     * 检查用户名是否存在
     */
    @GetMapping("/check/username/{username}")
    public Result<Boolean> checkUsernameExists(@PathVariable String username) {
        boolean exists = userService.checkUsernameExists(username);
        return Result.success(exists);
    }

    /**
     * 检查邮箱是否存在
     */
    @GetMapping("/check/email/{email}")
    public Result<Boolean> checkEmailExists(@PathVariable String email) {
        boolean exists = userService.checkEmailExists(email);
        return Result.success(exists);
    }
}