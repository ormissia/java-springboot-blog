package com.ormissia.blog.dao;

import com.ormissia.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/14 18:34
 * <p>
 * 对博客相关的CRUD操作
 */
@Mapper
public interface BlogDao {

    //增
    //保存博客详细信息
    Integer insertBlogInformation(@Param("blog") Blog blog);
    //保存博客内容
    Integer insertBlogContent(@Param("blog") Blog blog);
    //保存博客和标签的对应关系
    Integer insertBlogTags(@Param("blog") Blog blog);

    //删
    //删除博客和标签的对应关系（用于修改博客时使用，删除后重新添加）
    Integer deleteBlogTags(@Param("blog") Blog blog);

    //查
    //统计博客总数，是否统计未删除的根据参数决定
    Integer selectBlogTotal(@Param("isDeleted") Boolean isDeleted);
    //根据博客Id查询博客信息
    Blog selectBlogByBlogId(@Param("blogId") String blogId);
    //根据分页参数查询博客列表
    ArrayList<Blog> selectBlogByPage(@Param("page") HashMap<String,Object> page);


    //改
    //修改博客信息
    Integer updateBlog(@Param("blog") Blog blog);

}
