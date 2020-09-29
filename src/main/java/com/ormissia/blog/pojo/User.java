package com.ormissia.blog.pojo;

import java.io.Serializable;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/25 16:06
 * <p>
 * 用户实体类
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;//用户ID
    private String userRoleId;//用户权限ID
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private String phoneNumber;//手机号
    private String headPortrait;//用户头像
    private String registerDate;//注册时间
    private String lastEditPasswordDate;//最近修改密码的时间

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userRoleId='" + userRoleId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", lastEditPasswordDate='" + lastEditPasswordDate + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getLastEditPasswordDate() {
        return lastEditPasswordDate;
    }

    public void setLastEditPasswordDate(String lastEditPasswordDate) {
        this.lastEditPasswordDate = lastEditPasswordDate;
    }
}
