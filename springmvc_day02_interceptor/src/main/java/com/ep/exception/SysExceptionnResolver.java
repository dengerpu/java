package com.ep.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 自定义异常处理器
* */
public class SysExceptionnResolver implements HandlerExceptionResolver {
    //跳转到错误页面
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //捕获到异常对象
        SysException sysException = null;
        if(e instanceof SysException){
            sysException = (SysException) e;
        }else{
            sysException = new SysException("系统正在维护.....");
        }

//        创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",sysException.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
