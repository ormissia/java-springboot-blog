package com.ormissia.blog.config;

import com.ormissia.blog.pojo.ReturnResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/11/2 8:09
 * <p>
 * 登录拦截器
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    //预处理回调方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //通过session判断是否登录
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

       if (username == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                ReturnResult returnResult = new ReturnResult();
                returnResult.setCode(501);
                returnResult.setMessage("请先登录！");
                out= response.getWriter();
                out.append(returnResult.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }
        return true;
    }

    //后处理回调方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //整个请求处理完毕后的回调方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
