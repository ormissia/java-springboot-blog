package com.ormissia.blog.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 安红豆
 * @Date: Create in 2020/11/1 19:41
 * <p>
 * 字符串处理的工具类
 */
public class StringFactory {

    //获取图片路径
    public String getImagePath() {
        //动态获取当前绝对路径作为相对路径使用
        String relativePath = getRelativePath();

        //图片存储路径，按照年月区分图片路径
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String thisMonth = sdf.format(new Date());

        String imagePath = relativePath + "/image/top-image/" + thisMonth;
        return imagePath;
    }

    //获取当前绝对路径，用于文件操作相关
    public String getRelativePath() {

        return new File("").getAbsolutePath();
    }
}
