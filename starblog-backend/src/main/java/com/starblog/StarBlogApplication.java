package com.starblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.starblog.mapper")
public class StarBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarBlogApplication.class, args);
    }
}