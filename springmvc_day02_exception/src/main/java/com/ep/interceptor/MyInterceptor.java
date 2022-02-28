package com.ep.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 自定义拦截器   ctrl+o 重写接口方法
* */
public class MyInterceptor implements HandlerInterceptor {
    /*
    *  预处理，controller方法执行前
    *  return true 放行，执行下一个拦截器，如果没有，执行controller中的方法
    *  return false 不放行
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器preHandle执行了.....前1111");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }

    //后处理方法：controller方法执行之后，success.jsp执行之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器postHandle执行了.....后1111");
    }

    //success.jsp页面执行后，该方法会执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器afterCompletion执行了.....最后1111");
    }
}
