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

    //批量新增标签接口
    Integer insertTags(ArrayList<Tag> tags);

    //标签修改接口
    Integer updateTag(Tag tag);

    //标签查询接口
    //统计标签总数，是否统计未删除的根据参数决定
    Integer selectTagTotal(HashMap<String, Object> page);

    //根据分页数据查询标签列表
    ArrayList<Tag> selectTagByPage(HashMap<String, Object> page);

    //根据类型名字查询类型是否存在
    Integer selectTagByTagName(String tagName);
}
