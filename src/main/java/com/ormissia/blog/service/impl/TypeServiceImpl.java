package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.TypeDao;
import com.ormissia.blog.pojo.Type;
import com.ormissia.blog.service.TypeService;
import com.ormissia.blog.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/18 22:20
 * <p>
 * 类型相关的接口
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeDao typeDao;

    //类型新增接口
    @Override
    @Transactional
    public Integer insertType(Type type) {
        return typeDao.insertType(type);
    }

    //类型修改接口
    @Override
    @Transactional
    public Integer updateType(Type type) {
        return typeDao.updateType(type);
    }

    //类型查询接口
    //根据分页数据查询类型列表
    @Override
    public HashMap<String,Object> selectTypeByPage(HashMap<String, Object> page) {
        //查询类型总数
        Integer total = typeDao.selectTypeTotal(page);
        //查询当前页的type列表
        ArrayList<Object> typeList = typeDao.selectTypeByPage(page);

        //使用工具类创建分页返回值对象
        return new PageResult(total,typeList);
    }

    //根据名称查询类型是否已存在
    @Override
    public Type selectTypeByTypeName(String typeName) {
        return typeDao.selectTypeByTypeName(typeName);
    }
}
