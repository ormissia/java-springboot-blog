package com.ormissia.blog.service;

import com.ormissia.blog.pojo.Blog;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/13 20:02
 * <p>
 * 博客相关的Service层接口
 */
public interface BlogService {

    //博客新增接口
    Integer insertBlog(Blog blog);

    //博客保存接口
    Integer updateBlog(Blog blog);

    //博客查询接口
    Blog selectBlogByBlogId(String blogId);

}
