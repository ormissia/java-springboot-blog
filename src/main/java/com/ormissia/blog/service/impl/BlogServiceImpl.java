package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.BlogDao;
import com.ormissia.blog.dao.TagDao;
import com.ormissia.blog.pojo.Blog;
import com.ormissia.blog.pojo.Tag;
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

    @Resource
    private TagDao tagDao;

    //博客保存接口，并且添加事务
    @Override
    @Transactional
    public Integer insertBlog(Blog blog, ArrayList<String> tagsName) {
        //处理前端传过来的tagsName，将数据库中不存在的新tag插入数据库
        if (tagsName != null && tagsName.size() > 0) {
            insertNewTags(tagsName);
            //查询插入之后的所有tagsList
            blog.setTags(tagDao.selectTagsByTagName(tagsName));
        }

        //分别调用对应的方法保存博客信息到相应的表
        //保存博客信息
        blogDao.insertBlogInformation(blog);
        //保存博客内容
        blogDao.insertBlogContent(blog);

        //插入不需要删除原来的，因为是插入，原来不可能有^。^
        //删除原来的博客和tag对应关系并插入新的博客和tags的对应关系
        //blogDao.deleteBlogTags(blog);
        //如果博客的标签List不为空，则保存博客和标签的多对多关系
        if (blog.getTags() != null) {
            blogDao.insertBlogTags(blog);
        }
        return null;
    }

    //博客修改接口
    @Override
    @Transactional
    public Integer updateBlog(Blog blog, ArrayList<String> tagsName) {
        //处理前端传过来的tagsName，将数据库中不存在的新tag插入数据库
        if (tagsName != null && tagsName.size() > 0) {
            insertNewTags(tagsName);
            //查询插入之后的所有tagsList
            blog.setTags(tagDao.selectTagsByTagName(tagsName));
        }

        //修改博客信息
        blogDao.updateBlog(blog);
        //修改博客和标签对应关系(先删除，后添加)
        blogDao.deleteBlogTags(blog);
        //如果博客的标签List不为空，则保存博客和标签的多对多关系
        if (blog.getTags() != null) {
            blogDao.insertBlogTags(blog);
        }
        return null;
    }

    //查询博客总数
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

    //接收前端传过来的tagsName集合，将原来不存在的新tag插入数据库中
    //调用时需要开启事务
    private void insertNewTags(ArrayList<String> tagsName) {
        //先判断是否有之前不存在的type和tags
        ArrayList<Tag> existTags = tagDao.selectTagsByTagName(tagsName);    //已存在的tag列表
        ArrayList<String> newTagsName = new ArrayList<>(tagsName);          //使用ArrayList的构造方法创建一个新的与tagsName内容相同的Arraylist
        //遍历查到的数据库中已存在的tagList，从前端传过来的tagsName中删除这些已存在的
        for (Tag tag : existTags) {
            newTagsName.remove(tag.getTagName());
        }
        //将删除已存在的tagName后的tagsName插入数据库tag表中
        if (newTagsName.size() > 0) {
            tagDao.insertTags(newTagsName);
        }
    }
}
