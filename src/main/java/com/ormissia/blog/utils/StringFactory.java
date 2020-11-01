package com.ormissia.blog.utils;

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
        //图片存储路径，按照年月区分图片路径
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String thisMonth = sdf.format(new Date());

        String imagePath = "C:/topImage/" + thisMonth;
        return imagePath;
    }
}
