package com.ep.ui;


import com.ep.dao.AccountDao;
import com.ep.services.AccountService;
import com.ep.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
*  获取spring的Ioc核心容器，并根据id获取对象
* ApplicationContext的三个常用实现类
*       ClassPathXmlApplicationContext:他可以加在类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不出来（更常用）
*       FileSystemXmlApplicationContext:它可以加在磁盘任意路径下的配置文件（必须有访问权限）
*       AnnotationConfigApplicationContext：它是用于读取注解创建容器的
*
* 核心容器的两个接口引发出的问题
*       ApplicationContext：单例对象使用   采用此接口
*           它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中的对象
*       BeanFactory:      多例对象使用
*           它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
*
*
*
* */
public class Client {
    public static void main(String[] args) {
//        //1.获取核心容器对象
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//
//       // FileSystemXmlApplicationContext ac = new FileSystemXmlApplicationContext("D:\\@java_study\\spring_day01_spring\\src\\main\\resources\\bean.xml");
//        //2.根据id获取Bean对象
//        AccountService accountService = (AccountServiceImpl)ac.getBean("accountService");
//        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//
//        System.out.println(accountDao);
//        System.out.println(accountService);

        //accountDao.saveAccount();

        //-----------BeanFactory------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService accountService = (AccountServiceImpl)factory.getBean("accountService");

        System.out.println(accountService);
    }
}
