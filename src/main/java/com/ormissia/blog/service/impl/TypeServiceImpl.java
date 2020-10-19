package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.TypeDao;
import com.ormissia.blog.pojo.Type;
import com.ormissia.blog.service.TypeService;
import org.springframework.stereotype.Service;

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
    public Integer insertType(Type type) {
        return typeDao.insertType(type);
    }

    //类型修改接口
    @Override
    public Integer updateType(Type type) {
        return typeDao.updateType(type);
    }

    //类型查询接口

    @Override
    public Integer selectTypeTotal(HashMap<String, Object> page) {
        return typeDao.selectTypeTotal(page);
    }

    //根据分页数据查询类型列表
    @Override
    public ArrayList<Type> selectTypeByPage(HashMap<String, Object> page) {
        return typeDao.selectTypeByPage(page);
    }
}
