package com.ormissia.blog.service.impl;

import com.ormissia.blog.service.FileService;
import com.ormissia.blog.utils.StringFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author 安红豆
 * @Date: Create in 2020/11/1 16:59
 */
@Service("FileService")
public class FileServiceImpl implements FileService {
    @Override
    public String savePicByFormData(MultipartFile file) throws IOException {
        //获取图片存储路径
        String classpath = ResourceUtils.getFile("classpath:").getAbsolutePath();
        //相对路径
        String relativePath = new StringFactory().getImagePath();
        String path = classpath + relativePath;

        //判断是否有路径
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        //使用UUID生成图片文件名
        String fileName = UUID.randomUUID() + ".jpg";

        File tempFile = new File(path, fileName);
        //文件不存在则创建文件
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return relativePath + fileName;
    }
}
