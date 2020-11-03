package com.ormissia.blog.service.impl;

import com.ormissia.blog.service.FileService;
import com.ormissia.blog.utils.StringFactory;
import org.springframework.stereotype.Service;
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
        //生成图片存储路径
        String relativePath = new StringFactory().getRelativePath();
        String imagePath = new StringFactory().getImagePath();
        String completePath = relativePath + imagePath;
        //判断是否有路径
        if (!new File(completePath).exists()) {
            new File(completePath).mkdirs();
        }
        //使用UUID生成图片文件名
        String fileName = UUID.randomUUID() + ".jpg";
        File tempFile = new File(completePath, fileName);
        //文件不存在则创建文件
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return imagePath + "/" + fileName;
    }
}
