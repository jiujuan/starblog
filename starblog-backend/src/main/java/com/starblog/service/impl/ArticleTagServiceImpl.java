package com.starblog.service.impl;

import com.starblog.entity.ArticleTag;
import com.starblog.mapper.ArticleTagMapper;
import com.starblog.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public boolean addArticleTag(ArticleTag articleTag) {
        articleTag.setCreateTime(new Date());
        return articleTagMapper.insert(articleTag) > 0;
    }

    @Override
    public boolean batchAddArticleTag(List<ArticleTag> articleTags) {
        Date now = new Date();
        for (ArticleTag articleTag : articleTags) {
            articleTag.setCreateTime(now);
        }
        return articleTagMapper.batchInsert(articleTags) > 0;
    }

    @Override
    public boolean deleteArticleTag(Long id) {
        return articleTagMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByArticleId(Long articleId) {
        return articleTagMapper.deleteByArticleId(articleId) > 0;
    }

    @Override
    public boolean deleteByTagId(Long tagId) {
        return articleTagMapper.deleteByTagId(tagId) > 0;
    }

    @Override
    public boolean deleteByArticleIdAndTagId(Long articleId, Long tagId) {
        return articleTagMapper.deleteByArticleIdAndTagId(articleId, tagId) > 0;
    }

    @Override
    public ArticleTag getArticleTagById(Long id) {
        return articleTagMapper.selectById(id);
    }

    @Override
    public List<ArticleTag> getArticleTagsByArticleId(Long articleId) {
        return articleTagMapper.selectByArticleId(articleId);
    }

    @Override
    public List<ArticleTag> getArticleTagsByTagId(Long tagId) {
        return articleTagMapper.selectByTagId(tagId);
    }

    @Override
    public ArticleTag getArticleTagByArticleIdAndTagId(Long articleId, Long tagId) {
        return articleTagMapper.selectByArticleIdAndTagId(articleId, tagId);
    }
}