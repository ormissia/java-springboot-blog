package com.ormissia.blog.pojo;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 11:12
 * <p>
 * 博客类型实体类
 */
public class Type {
    private Integer typeId;//类型ID
    private String typeName;//类型名称

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
