package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 用于创建Service的代理对象的工厂
* */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManger txManger;

    public void setTxManger(TransactionManger txManger) {
        this.txManger = txManger;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /*
    * 获取Service代理对象
    * */
    public IAccountService getAccountService(){

       return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    txManger.beginTransaction();
                    //2.执行操作
                    rtValue = method.invoke(accountService,args);
                    //3.提交事务
                    txManger.commit();
                    return rtValue;

                } catch (Exception e) {
                    //5.回滚操作
                    txManger.rollback();
                    e.printStackTrace();

                } finally {
                    //6.释放连接
                    txManger.release();
                }
                return rtValue;
            }
        });
    }
}
