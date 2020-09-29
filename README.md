# ormissia_blog ![](https://badgen.net/badge/github/Blog/blue?label=JAVA)

## 我的博客后端项目

---
### 创建表结构的SQL
###### 按顺序创建
```mysql
-- 用户表
CREATE TABLE user
(
    `userId`               varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
    `userRoleId`           varchar(100) DEFAULT NULL COMMENT '用户权限ID',
    `username`             varchar(100)                                            NOT NULL COMMENT '用户名',
    `password`             varchar(100)                                            NOT NULL COMMENT '密码',
    `email`                varchar(100) DEFAULT NULL COMMENT '邮箱',
    `phoneNumber`          varchar(100) DEFAULT NULL COMMENT '手机号',
    `headPortrait`         varchar(100) DEFAULT NULL COMMENT '头像',
    `registerDate`         datetime                                                NOT NULL COMMENT '用户注册时间',
    `lastEditPasswordDate` datetime     DEFAULT NULL COMMENT '最近一次修改密码的日期',
    PRIMARY KEY (`userId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
```
```mysql
-- 类型表
CREATE TABLE type
(
    `typeId`   int          NOT NULL AUTO_INCREMENT COMMENT '类型ID',
    `typeName` varchar(100) NOT NULL COMMENT '类型名称',
    PRIMARY KEY (`typeId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
```
```mysql
-- 标签表
CREATE TABLE tag
(
    `tagId`   int          NOT NULL AUTO_INCREMENT COMMENT '标签ID',
    `tagName` varchar(100) NOT NULL COMMENT '标签名称',
    PRIMARY KEY (`tagId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
```
```mysql
-- 博客内容表
CREATE TABLE blog
(
    `blogId`       varchar(100) NOT NULL COMMENT '博客ID',
    `userId`       varchar(100) NOT NULL COMMENT '博客所属用户的ID',
    `typeId`       int          DEFAULT NULL COMMENT '类型ID，默认为-1，即无类型',
    `blogTitle`    varchar(100) NOT NULL COMMENT '博客标题',
    `description`  varchar(255) NOT NULL COMMENT '博客描述',
    `blogContent`  longtext     NOT NULL COMMENT '博客内容',
    `createDate`   varchar(100) NOT NULL COMMENT '创建时间',
    `lastEditDate` varchar(100) DEFAULT NULL COMMENT '上一次修改时间',
    `deleteDate`   varchar(100) DEFAULT NULL COMMENT '删除时间',
    `deleted`      int          DEFAULT NULL COMMENT '是否标记为删除，0或NULL-正常，1-标记为删除',
    `recommend`    int          DEFAULT NULL COMMENT '推荐，0或NULL-正常，1-推荐',
    `publish`      int          DEFAULT NULL COMMENT '发布，0或NULL-草稿，1-发布',
    `visits`       int          DEFAULT NULL COMMENT '访客数量',
    PRIMARY KEY (`blogId`),
    KEY `blog_FK` (`userId`),
    KEY `blog_FK_1` (`typeId`),
    CONSTRAINT `blog_FK` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT `blog_FK_1` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
```
```mysql
-- 博客标签关系表
CREATE TABLE blog_tag
(
    `blogId` varchar(100) NOT NULL COMMENT '博客ID',
    `tagId`  int          NOT NULL COMMENT '标签ID',
    KEY `blog_tag_FK` (`blogId`),
    KEY `blog_tag_FK_1` (`tagId`),
    CONSTRAINT `blog_tag_FK` FOREIGN KEY (`blogId`) REFERENCES `blog` (`blogId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `blog_tag_FK_1` FOREIGN KEY (`tagId`) REFERENCES `tag` (`tagId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
```