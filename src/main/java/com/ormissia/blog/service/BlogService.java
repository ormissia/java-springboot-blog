package com.ormissia.blog.service;

import com.ormissia.blog.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/13 20:02
 * <p>
 * 博客相关的Service层接口
 */
public interface BlogService {

    //博客新增接口
    Integer insertBlog(Blog blog);

    //博客修改接口
    Integer updateBlog(Blog blog);

    //博客查询接口
    //统计博客总数，是否统计未删除的根据参数决定
    Integer selectBlogTotal(HashMap<String, Object> page);

    //根据博客Id查询博客信息
    Blog selectBlogByBlogId(String blogId);

    //根据分页数据查询博客列表
    ArrayList<Blog> selectBlogByPage(HashMap<String, Object> page);

}
