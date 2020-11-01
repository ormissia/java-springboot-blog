package com.ormissia.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author 安红豆
 * @Date: Create in 2020/11/1 16:55
 * <p>
 * 文件处理的Service层接口
 */
public interface FileService {

    //保存图片的接口
    String savePicByFormData(MultipartFile file) throws IOException;
}
