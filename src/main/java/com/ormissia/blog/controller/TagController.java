package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnResult;
import com.ormissia.blog.pojo.Tag;
import com.ormissia.blog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/20 21:05
 * <p>
 * 标签相关
 */

@RestController
@RequestMapping("/api")
@Api(tags = "标签控制器")
public class TagController {

    @Resource
    private TagService tagService;

    //新增或者修改单个标签
    @RequestMapping(value = "/private/createNewTag", method = RequestMethod.POST)
    @ApiOperation("保存类型的接口")
    public ReturnResult<String> createNewTag(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<String> result = new ReturnResult<>();

        //解析类型相关属性
        Integer tagId = (Integer) requestBody.get("tagId");
        String tagName = (String) requestBody.get("tagName");

        //创建用于保存的Tag对象
        Tag tag = new Tag();
        tag.setTagName(tagName);

        //判断tagId是否为"-1"，如果为"-1"则是新创建的类型
        if (-1 == tagId) {
            //tagId为空，创建新的tag
            //新建之前先判断是否已存在相同的标签名字
            if (tagService.selectTagByTagName(tagName) != null) {
                result.setCode(ReturnResult.STATUS_INTERNAL_RESPONSE_SERVER_ERROR_VALUE);
                result.setMessage("标签已存在！");
                return result;
            }
            tagService.insertTag(tag);
        } else {
            //tagId不为"-1"，即为修改博客
            tag.setTagId(tagId);
            tagService.updateTag(tag);
        }

        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("标签保存成功！");
        return result;
    }

    //按照分页参数查询标签列表
    @RequestMapping(value = "/private/selectTagByPage", method = RequestMethod.POST)
    @ApiOperation("根据分页数据来查询标签的接口")
    public ReturnResult<HashMap<String, Object>> selectTagByPage(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<HashMap<String, Object>> result = new ReturnResult<>();

        //获取请求参数
        String queryStr = (String) requestBody.get("queryStr");
        Integer pageNum = (Integer) requestBody.get("pageNum");
        Integer pageSize = (Integer) requestBody.get("pageSize");

        //创建page的HashMap，用于分页查询参数
        HashMap<String, Object> page = new HashMap<>();
        page.put("queryStr", queryStr);
        page.put("pageNum", (pageNum - 1) * pageSize);
        page.put("pageSize", pageSize);

        //分页查询结果
        HashMap<String, Object> data = tagService.selectTagByPage(page);

        //给返回结果对象赋值
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("查询成功");
        result.setData(data);

        return result;
    }

    //查询所有tag并统计每个tag包含的blog数量
    @RequestMapping(value = "/public/selectTagCountBlog", method = RequestMethod.GET)
    @ApiOperation("查询所有tag并统计每个tag包含的blog舒利昂")
    public ReturnResult<ArrayList<Tag>> selectTagCountBlog() {
        ReturnResult<ArrayList<Tag>> result = new ReturnResult<>();

        ArrayList<Tag> data = tagService.selectTagCountBlog();
        //给返回结果对象赋值
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("查询成功");
        result.setData(data);
        return result;
    }

}
