package com.starblog.service.impl;

import com.starblog.entity.Tag;
import com.starblog.mapper.TagMapper;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TagServiceImplTest {

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private TagServiceImpl tagService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddTag() {
        Tag tag = new Tag();
        tag.setName("测试标签");

        when(tagMapper.insert(any(Tag.class))).thenReturn(1);

        boolean result = tagService.addTag(tag);
        assertTrue(result);
        assertNotNull(tag.getCreateTime());
        assertNotNull(tag.getUpdateTime());
    }

    @Test
    public void testGetTagById() {
        Tag tag = new Tag();
        tag.setId(1L);
        tag.setName("测试标签");
        tag.setCreateTime(new Date());
        tag.setUpdateTime(new Date());

        when(tagMapper.selectById(anyLong())).thenReturn(tag);

        Tag result = tagService.getTagById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("测试标签", result.getName());
    }

    @Test
    public void testGetTagByName() {
        Tag tag = new Tag();
        tag.setId(1L);
        tag.setName("测试标签");
        tag.setCreateTime(new Date());
        tag.setUpdateTime(new Date());

        when(tagMapper.selectByName(anyString())).thenReturn(tag);

        Tag result = tagService.getTagByName("测试标签");
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("测试标签", result.getName());
    }

    @Test
    public void testGetAllTags() {
        List<Tag> tags = new ArrayList<>();
        Tag tag1 = new Tag();
        tag1.setId(1L);
        tag1.setName("测试标签1");
        tags.add(tag1);

        Tag tag2 = new Tag();
        tag2.setId(2L);
        tag2.setName("测试标签2");
        tags.add(tag2);

        when(tagMapper.selectAll()).thenReturn(tags);

        List<Tag> result = tagService.getAllTags();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("测试标签1", result.get(0).getName());
        assertEquals("测试标签2", result.get(1).getName());
    }
}