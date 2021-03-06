package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/*
* 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
* */
@Component("txManger")
@Aspect
public class TransactionManger {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt(){}
    /*
    * 开启事务
    * */
   // @Before("pt()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 提交事务
     * */
    //@AfterReturning("pt()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 回滚事务
     * */
   // @AfterThrowing("pt()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 释放连接
     * */
   // @After("pt()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();  //还回连接池中
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Around("pt()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
       try{

           //1.获取参数
           Object[] args = pjp.getArgs();
           //2.开启事务
           this.beginTransaction();
           //3.执行方法
           rtValue = pjp.proceed(args);
           //4.提交事务
           this.commit();
       }catch (Throwable e){
           //5.回滚事务
           this.rollback();
           throw new RuntimeException(e);
       }finally {
           //6.释放资源
           this.release();
       }
       return rtValue;
    }
}
