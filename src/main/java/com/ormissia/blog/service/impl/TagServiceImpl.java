package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.TagDao;
import com.ormissia.blog.pojo.Tag;
import com.ormissia.blog.service.TagService;
import com.ormissia.blog.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/20 21:04
 */

@Service("TagService")
public class TagServiceImpl implements TagService {

    @Resource
    TagDao tagDao;

    //标签新增接口
    @Override
    @Transactional
    public Integer insertTag(Tag tag) {
        return tagDao.insertTag(tag);
    }

    //标签修改接口
    @Override
    @Transactional
    public Integer updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    //标签查询接口
    //根据分页数据查询标签列表
    @Override
    public HashMap<String,Object> selectTagByPage(HashMap<String, Object> page) {
        //查询标签总数
        Integer total = tagDao.selectTagTotal(page);
        //查询当前页的tag列表
        ArrayList<Object> tagList = tagDao.selectTagByPage(page);

        //使用工具类创建分页返回值对象
        return new PageResult(total,tagList);
    }

    //查询所有tag并统计每个tag包含的blog数量
    @Override
    public ArrayList<Tag> selectTagCountBlog() {
        return tagDao.selectTagCountBlog();
    }

    //根据标签名称查询类型是否存在
    @Override
    public Tag selectTagByTagName(String tagName) {
        return tagDao.selectTagByTagName(tagName);
    }

}
