package com.ormissia.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 16:30
 * <p>
 * Swagger2的配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //方法需要有ApiOperation注解才能生存接口文档
                .apis(RequestHandlerSelectors.basePackage("com.ormissia.blog.controller"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //路径使用any风格
                .paths(PathSelectors.any())
                //接口文档的基本信息
                .build();
    }

    //接口文档详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("我的博客的API")
                .description("欢迎访问我的博客：http://www.ormissia.com")
                .contact(new Contact("安红豆","http://www.ormissia.com","ormissia@outlook.com"))
                .version("1.0")
                .build();
    }

}
