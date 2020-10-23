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
    private User user;//博客所属用户实体类
    private Type type;//博客类型实体类
    private ArrayList<Tag> tags;//博客标签实体类集合
    private String blogTitle;//博客标题
    private String description;//博客描述
    private String blogContent;//博客内容
    private String createDate;//创建时间
    private String lastEditDate;//上一次修改时间
    private String deleteDate;//删除时间
    private Boolean isDeleted;//删除标记，0/null-未删除，1-删除
    private Boolean isRecommend;//推荐标记，0/null-普通，1-推荐
    private Boolean isPublished;//发布标记，0/null-草稿，1-发布
    private Integer visits;//访客数量

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", user=" + user +
                ", type=" + type +
                ", tags=" + tags +
                ", blogTitle='" + blogTitle + '\'' +
                ", description='" + description + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createDate='" + createDate + '\'' +
                ", lastEditDate='" + lastEditDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", isDeleted=" + isDeleted +
                ", isRecommend=" + isRecommend +
                ", isPublished=" + isPublished +
                ", visits=" + visits +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }
}
