package com.ormissia.blog.dao;

import com.ormissia.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    //根据博客Id查询博客信息
    Blog selectBlogByBlogId(@Param("blogId") String blogId);

    //改
    //修改博客信息
    Integer updateBlog(@Param("blog") Blog blog);

}
