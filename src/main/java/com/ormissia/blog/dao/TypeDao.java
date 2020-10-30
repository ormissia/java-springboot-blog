package com.ormissia.blog.dao;

import com.ormissia.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/18 22:23
 * <p>
 * 对类型相关的CRUD操作接口
 */
@Mapper
public interface TypeDao {

    //增
    //插入类型
    Integer insertType(@Param("type") Type type);

    //删

    //查
    //统计类型总数，是否统计未删除的根据参数决定
    Integer selectTypeTotal(@Param("page") HashMap<String, Object> page);

    //根据分页参数查询类型列表
    ArrayList<Type> selectTypeByPage(@Param("page") HashMap<String, Object> page);

    //根据名称查询类型是否已存在
    Integer selectTypeByTypeName(@Param("typeName") String typeName);

    //改
    //修改类型信息
    Integer updateType(@Param("type") Type type);
}
