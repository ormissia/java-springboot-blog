package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.*;
import com.ormissia.blog.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 安红豆
 * @Date: Create in 2020/10/13 19:59
 * <p>
 * 博客相关
 */

@RestController
@RequestMapping("/api/private")
@Api(tags = "博客控制器")
public class BlogController {

    @Resource
    private BlogService blogService;

    //新增或修改博客
    @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
    @ApiOperation("保存博客的接口")
    public ReturnResult<LinkedHashMap<String, Object>> saveBlog(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<LinkedHashMap<String, Object>> result = new ReturnResult<>();

        //解析博客相关属性
        String blogId = String.valueOf(requestBody.get("blogId"));
        String blogTitle = String.valueOf(requestBody.get("blogTitle"));
        String description = String.valueOf(requestBody.get("description"));
        String blogContent = String.valueOf(requestBody.get("blogContent"));
        Integer isPublished = (Integer) requestBody.get("isPublished");
        Integer isRecommend = (boolean) requestBody.get("isRecommend") ? 1 : 0;
        //解析user相关属性
        String userId = String.valueOf(requestBody.get("userId"));
        //解析type相关属性
        String typeName = String.valueOf(requestBody.get("blogType"));
        //解析tags相关属性
        ArrayList<String> tagsName = (ArrayList<String>) requestBody.get("blogTags");


        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = simpleDateFormat.format(date);

        //创建用于保存的Blog对象
        Blog blog = new Blog();
        User user = new User();
        Type type = new Type();
        ArrayList<Tag> tags = new ArrayList<>();

        //用于保存博客是新建还是修改的状态，用于下面保存时候区分是插入还是修改,默认为true新增
        boolean newBlogFlag = true;

        //给用于保存的blog对象赋值
        //判断BlogId是否为空，如果为空则是新创建的博客
        if (blogId == null || "".equals(blogId)) {
            //blogId为空，则生成新的blogId
            blog.setBlogId(String.valueOf(UUID.randomUUID()));
            //只有新创建的博客才给createDate赋值
            blog.setCreateDate(now);
        } else {
            //blogId不为空是修改的博客，则将前端传过来的blogId赋值给blog,同时给上一次修改时间赋值
            blog.setBlogId(blogId);
            blog.setLastEditDate(now);
            //博客不是新增，将newBlogFlag置为false
            newBlogFlag = false;
        }
        blog.setBlogTitle(blogTitle);
        blog.setDescription(description);
        blog.setBlogContent(blogContent);
        blog.setIsRecommend(isRecommend);
        blog.setIsPublished(isPublished);

        user.setUserId(userId);

        blog.setUser(user);

        //调用service方法保存blog到数据库
        if (newBlogFlag) {
            blogService.insertBlog(blog);
        } else {
            blogService.updateBlog(blog);
        }

        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("博客保存成功^_^ 太棒了，奇怪的知识又增加了！");
        return result;
    }

    //根据博客Id来查询博客相关信息
    @RequestMapping(value = "/selectBlogByBlogId", method = RequestMethod.POST)
    @ApiOperation("根据博客Id来查询博客的接口")
    @ApiImplicitParam(name = "blogId", value = "博客Id", required = true, dataType = "String")
    public ReturnResult<Blog> saveBlog(@RequestParam("blogId") String blogId) {
        ReturnResult<Blog> result = new ReturnResult<>();

        //调用Service层接口查询Blog信息
        Blog blog = blogService.selectBlogByBlogId(blogId);

        //给返回结果对象赋值
        result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
        result.setMessage("查询成功");
        result.setData(blog);
        return result;
    }

}
