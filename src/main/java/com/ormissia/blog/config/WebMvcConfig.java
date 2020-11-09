package com.ormissia.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/25 14:17
 * <p>
 * Web配置类
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //开启/api/**的跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("POST", "GET", "PUT", "DELETE");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器,只拦截私有请求
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/api/private/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url映射
        //配置Server虚拟路径，handler为前台访问的路径，locations为files是相对应的本地路径
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
    }
}
