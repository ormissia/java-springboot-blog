package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.BlogDao;
import com.ormissia.blog.pojo.Blog;
import com.ormissia.blog.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/14 18:34
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    //博客保存接口，并且添加事务
    @Override
    @Transactional
    public Integer insertBlog(Blog blog) {

        //先判断是否有之前不存在的type和tags

        //分别调用对应的方法保存博客信息到相应的表
        //保存博客信息
        blogDao.insertBlogInformation(blog);
        //保存博客内容
        blogDao.insertBlogContent(blog);
        //保存博客和标签的多对多关系
        if (blog.getTags() != null) {
            blogDao.insertBlogTags(blog);
        }
        return null;
    }

    //博客修改接口
    @Override
    @Transactional
    public Integer updateBlog(Blog blog) {
        //修改博客信息
        blogDao.updateBlog(blog);
        //修改博客和标签对应关系(先删除，后添加)
//        blogDao.deleteBlogTags(blog);
//        blogDao.insertBlogTags(blog);
        return null;
    }

    @Override
    public Integer selectBlogTotal(HashMap<String, Object> page) {
        return blogDao.selectBlogTotal(page);
    }

    //根据博客Id查询博客信息
    @Override
    public Blog selectBlogByBlogId(String blogId) {
        return blogDao.selectBlogByBlogId(blogId);
    }

    //根据分页查询博客列表
    @Override
    public ArrayList<Blog> selectBlogByPage(HashMap<String, Object> page) {
        return blogDao.selectBlogByPage(page);
    }
}
