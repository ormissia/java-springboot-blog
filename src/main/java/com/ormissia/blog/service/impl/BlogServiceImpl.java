package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.BlogDao;
import com.ormissia.blog.pojo.Blog;
import com.ormissia.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/14 18:34
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    //博客保存接口
    @Override
    public Integer insertBlog(Blog blog) {
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
    public Integer updateBlog(Blog blog) {
        //修改博客信息
        blogDao.updateBlog(blog);
        //修改博客和标签对应关系(先删除，后添加)
//        blogDao.deleteBlogTags(blog);
//        blogDao.insertBlogTags(blog);
        return null;
    }

    //根据博客Id查询博客信息
    @Override
    public Blog selectBlogByBlogId(String blogId) {
        return blogDao.selectBlogByBlogId(blogId);
    }
}
