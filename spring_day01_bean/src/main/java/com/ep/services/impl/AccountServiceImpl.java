package com.ep.services.impl;


import com.ep.services.AccountService;

/*
* 账户业务层实现类
* */
public class AccountServiceImpl implements AccountService {

    //这种情况使用bean的第一种方式会报错
//    public  AccountServiceImpl(String name){
//
//        System.out.println("对象创建了\n");
//    }

    //可以写也可以不写，但是不能加参数
    public  AccountServiceImpl(){

        System.out.println("对象创建了\n");
    }

    public void init(){

        System.out.println("对象初始化.......");
    }
    public void destory(){

        System.out.println("对象销毁了.......");
    }
    public void saveAccount() {
        System.out.println("AccountService执行了saveAccount方法");
    }
}
