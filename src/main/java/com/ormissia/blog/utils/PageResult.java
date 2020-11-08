package com.ormissia.blog.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/11/8 21:35
 * <p>
 * 分页查询Service层返回至Controller层封装对象工具类
 */
public class PageResult extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    //HashMap的key常量
    //查询总数
    public static final String TOTAL = "total";
    //每一页的List
    public static final String DATA_LIST = "dataList";

    public PageResult() {
    }

    public PageResult(Integer total, ArrayList<Object> dataList) {
        super.put(TOTAL, total);
        super.put(DATA_LIST, dataList);
    }
}
