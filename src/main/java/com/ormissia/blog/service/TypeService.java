package com.ormissia.blog.service;

import com.ormissia.blog.pojo.Type;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/18 22:16
 */
public interface TypeService {

    //类型新增接口
    Integer insertType(Type type);

    //类型修改接口
    Integer updateType(Type type);

    //类型查询接口
    //根据分页数据查询类型列表
    HashMap<String,Object> selectTypeByPage(HashMap<String, Object> page);

    //根据名称查询类型是否已存在
    Type selectTypeByTypeName(String typeName);
}
