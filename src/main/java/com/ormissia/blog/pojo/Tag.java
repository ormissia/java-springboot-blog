package com.ormissia.blog.pojo;

import java.io.Serializable;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 11:14
 * <p>
 * 博客标签实体类
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer tagId;//标签ID
    private String tagName;//标签名称

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
