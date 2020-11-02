package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnResult;
import com.ormissia.blog.pojo.Type;
import com.ormissia.blog.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/15 22:41
 * <p>
 * 类型相关
 */

@RestController
@RequestMapping("/api")
@Api(tags = "类型控制器")
public class TypeController {

    @Resource
    private TypeService typeService;

    //新增或修改类型
    @RequestMapping(value = "/private/createNewType", method = RequestMethod.POST)
    @ApiOperation("保存类型的接口")
    public ReturnResult<String> createNewType(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<String> result = new ReturnResult<>();

        //解析类型相关属性
        Integer typeId = (Integer) requestBody.get("typeId");
        String typeName = (String) requestBody.get("typeName");

        //创建用于保存的Type对象
        Type type = new Type();
        type.setTypeName(typeName);

        //用于保存类型是新建还是修改的状态，用于下面保存时候区分是插入还是修改,默认为true新增
        boolean newTypeFlag = true;

        //判断typeId是否为"-1"，如果为"-1"则是新创建的类型
        if (-1 == typeId) {
            //typeId为空，创建新的type
            //新建之前先判断是否已存在相同的标签名字
            if (typeService.selectTypeByTypeName(typeName) != null) {
                result.setCode(ReturnResult.STATUS_INTERNAL_RESPONSE_SERVER_ERROR_VALUE);
                result.setMessage("类型已经存在！");
                return result;
            }
            typeService.insertType(type);
        } else {
            //typeId不为"-1"，即为修改博客
            type.setTypeId(typeId);
            typeService.updateType(type);
        }

        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("类型保存成功！");
        return result;
    }

    //按照分页参数查询类型列表
    @RequestMapping(value = "/private/selectTypeByPage", method = RequestMethod.POST)
    @ApiOperation("根据分页数据来查询类型的接口")
    public ReturnResult<LinkedHashMap<String, Object>> selectTypeByPage(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<LinkedHashMap<String, Object>> result = new ReturnResult<>();
        //用于存放列表数据和类型总数
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

        //查询类型列表
        ArrayList<Type> typeList = typeService.selectTypeByPage(page);

        //查询类型总数
        Integer total = typeService.selectTypeTotal(page);

        data.put("total", total);
        data.put("typeList", typeList);


        //给返回结果对象赋值
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("查询成功");
        result.setData(data);

        return result;
    }
}
