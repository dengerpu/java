package com.ep.services.impl;

import com.ep.dao.AccountDao;
import com.ep.dao.impl.AccountDaoImpl;
import com.ep.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
* 账户业务层实现类
*
*
*   曾经的xml配置：
*       <bean id="accountService" class="com.ep.services.impl.AccountServiceImpl"
*           scope="" init-method="" destory-method="">
*            <property name="" value ="" / ref=""></property>
*       </bean>
*
*   用于创建对象的
*       他们的多用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的
*       Component:
*           作用：用于把当前类对象存入spring容器中
*           属性： value:用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写
*       Controller:一般用于表现层
*       Service：一般用在业务层
*       Repository：一般用在持久层
*       以上三个注解他们的作用和属性与Component是一模一样的
*       他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
*
*   用于注入数据的
*       他们的作用就和在xml配置文件中bean标签中写一个<property>标签的作用是一样的
*       Autowired:
*           作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
*           出现位置：
*                   可以是变量上，也可以是方法上
*           细节：
*               在使用注解注入时，set方法就不是必须的了
*       Qualifier:
*           作用：在按照类中注入的基础之上再按照名称注入。他在类成员注入时不能单独使用，但是在方法参数注入时可以
*           属性：
*               value:用于指定bean的id
*       Resource：
*           作用：直接按照bean的id注入，他可以独立使用
*           属性：
*               name:用于指定bean的id
*    以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
*     另外，集合类型的注入只能通过xml来实现
*
*       Value
*           作用：用于注入基本类型和String类型的数据
*           属性：
*               value 用于指定数据的值，它可以使用spring中的Spel(也就是spring的el表达式)
*                       Spel的写法 ：${表达式}
*
*   用于改变作用范围的
*       他们的作用就和在bean标签汇总使用scope属性实现的功能是一样的
*        Scope
*           作用：用于指定bean的作用范围
*           属性:
*               value:指定范围的取值。常用取值：singleton prototype
* 和生命周期相关
*       他们的作用就和在bean标签中使用init-method和destory-method的作用是一样的
*       PreDestory
*               作用：用于指定销毁方法
*       PostConstruct
*               作用：用于指定初始化方法
\

* */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
//
//    @Autowired
//    @Qualifier("accountDao2")  类成员注入时，不可单独使用
    @Resource(name = "accountDao1")
   private AccountDao accountDao = null;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destory(){

        System.out.println("销毁方法执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
