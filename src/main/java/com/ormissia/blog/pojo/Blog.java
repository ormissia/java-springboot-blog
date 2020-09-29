package com.ormissia.blog.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 11:16
 * <p>
 * 博客实体类
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
    private String blogId;//博客ID
    private String userId;//博客所属用户ID
    private Integer typeId;//博客类型ID
    private ArrayList<Tag> tagIds;//博客标签集合
    private String blogTitle;//博客标题
    private String description;//博客描述
    private String blogContent;//博客内容
    private String createDate;//创建时间
    private String lastEditDate;//上一次修改时间
    private String deleteDate;//删除时间
    private Integer deleted;//删除标记，0/null-未删除，1-删除
    private Integer recommend;//推荐标记，0/null-普通，1-推荐
    private Integer publish;//发布标记，0/null-草稿，1-发布
    private Integer visits;//访客数量

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public ArrayList<Tag> getTagIds() {
        return tagIds;
    }

    public void setTagIds(ArrayList<Tag> tagIds) {
        this.tagIds = tagIds;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }
}
