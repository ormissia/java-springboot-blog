package com.ormissia.blog.service;

import com.ormissia.blog.pojo.Tag;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/20 21:04
 */
public interface TagService {

    //标签新增接口
    Integer insertTag(Tag tag);

    //标签修改接口
    Integer updateTag(Tag tag);

    //标签查询接口
    //根据分页数据查询标签列表
    HashMap<String,Object> selectTagByPage(HashMap<String, Object> page);

    //查询所有tag并统计每个tag包含的blog数量
    ArrayList<Tag> selectTagCountBlog();

    //根据类型名字查询类型是否存在
    Tag selectTagByTagName(String tagName);
}
