package com.ormissia.blog.dao;

import com.ormissia.blog.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/20 21:04
 * <p>
 * 对标签相关的CRUD操作接口
 */
public interface TagDao {

    //增
    //插入单个标签
    Integer insertTag(@Param("tag") Tag tag);

    //批量插入标签
    Integer insertTags(@Param("tagsName") ArrayList<String> tagsName);

    //删

    //查
    //统计标签总数，是否统计未删除的根据参数决定
    Integer selectTagTotal(@Param("page") HashMap<String, Object> page);

    //根据分页参数查询类型标签列表
    ArrayList<Object> selectTagByPage(@Param("page") HashMap<String, Object> page);

    //根据类型名称查询类型是否存在
    Tag selectTagByTagName(@Param("tagName") String tagName);

    //查询所有tag并统计每个tag包含的blog数量
    ArrayList<Tag> selectTagCountBlog();

    //根据标签名称集合查询类型存在的标签集合
    ArrayList<Tag> selectTagsByTagName(@Param("tagsName") ArrayList<String> tagsName);

    //改
    //修改标签信息
    Integer updateTag(@Param("tag") Tag tag);

}
