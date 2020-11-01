package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnResult;
import com.ormissia.blog.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author 安红豆
 * @Date: Create in 2020/11/1 16:49
 * <p>
 * 文件相关接口
 */

@RestController
@RequestMapping("/api/private")
@Api(tags = "文件控制器")
public class FileController {

    @Resource
    private FileService fileService;

    //上传图片
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ApiOperation("上传图片的接口")
    public ReturnResult<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        ReturnResult<String> result = new ReturnResult<>();
        //调用Service层方法存储图片
        String filePath = fileService.savePicByFormData(file);

        //生成返回对象
        result.setData(filePath);
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("图片上传成功");
        return result;
    }
}
