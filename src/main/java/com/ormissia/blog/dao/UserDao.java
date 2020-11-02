package com.ormissia.blog.dao;

import com.ormissia.blog.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 14:45
 *
 * 对用户相关的CRUD相关操作接口
 */
public interface UserDao {
    //增

    //删

    //查
    User selectUserByUsername(@Param("username") String username);

    //改

}
