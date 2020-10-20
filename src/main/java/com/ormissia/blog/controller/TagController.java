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
import java.util.LinkedHashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/20 21:05
 * <p>
 * 标签相关
 */

@RestController
@RequestMapping("/api/private")
@Api(tags = "标签控制器")
public class TagController {

    @Resource
    private TagService tagService;

    //新增或者修改单个标签
    @RequestMapping(value = "/createNewTag", method = RequestMethod.POST)
    @ApiOperation("保存类型的接口")
    public ReturnResult<String> createNewTag(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<String> result = new ReturnResult<>();

        //解析类型相关属性
        Integer tagId = (Integer) requestBody.get("tagId");
        String tagName = (String) requestBody.get("tagName");

        //创建用于保存的Tag对象
        Tag tag = new Tag();
        tag.setTagName(tagName);

        //判断tagId是否为空，如果为空则是新创建的类型
        if (tagId == null || "".equals(tagId)) {
            //tagId为空，创建新的tag
            // TODO 新建之前先判断是否已存在相同的标签名字
            tagService.insertTag(tag);
        } else {
            //tagId不为空，即为修改博客
            tag.setTagId(tagId);
            tagService.updateTag(tag);
        }

        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("标签添加成功！");
        return result;
    }

    // TODO 批量新增标签

    //按照分页参数查询标签列表
    @RequestMapping(value = "/selectTagByPage", method = RequestMethod.POST)
    @ApiOperation("根据分页数据来查询标签的接口")
    public ReturnResult<LinkedHashMap<String, Object>> selectTagByPage(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<LinkedHashMap<String, Object>> result = new ReturnResult<>();
        //用于存放列表数据和标签总数
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();

        //获取请求参数
        String queryStr = (String) requestBody.get("queryStr");
        Integer pageNum = (Integer) requestBody.get("pageNum");
        Integer pageSize = (Integer) requestBody.get("pageSize");

        //创建page的HashMap，用于分页查询参数
        HashMap<String, Object> page = new HashMap<>();
        page.put("queryStr", queryStr);
        page.put("pageNum", (pageNum - 1) * pageSize);
        page.put("pageSize", pageSize);

        //查询标签列表
        ArrayList<Tag> tagList = tagService.selectTagByPage(page);

        //查询标签总数
        Integer total = tagService.selectTagTotal(page);

        data.put("total", total);
        data.put("tagList", tagList);

        //给返回结果对象赋值
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("查询成功");
        result.setData(data);

        return result;
    }

}
