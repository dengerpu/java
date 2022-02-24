package com.ep.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class jdbctemplate02 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbctemplate", JdbcTemplate.class);

        jt.execute("insert into account(name,money)values('jdbc',100)");

//        //准备数据源，spring的内置数据源
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/spring");
//        ds.setUsername("root");
//        ds.setPassword("root");
//
//        //1.创建jdbcTemplate对象
//        JdbcTemplate jt = new JdbcTemplate();
//        //给jt设置数据源
//        jt.setDataSource(ds);
//        //2.执行操作
//        jt.execute("insert into account(name,money)values('ddd',100)");
    }
}
