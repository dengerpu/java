package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.User;
import com.ep.mapper.UserMapper;
import com.ep.mapper.UserXmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorsystemApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;


    /*
    * 测试mybatis注解配置的引用
    * */
    @Test
    public void test() {
//        List<User> users = userMapper.queryUserList();
//        System.out.println(users);
    }

    /*
    *
    * 测试mybatis基于xml配置方式的引用
    * */

    @Test
    public void test2() {
//        List<User> users = userXmlMapper.queryUserList();
//        System.out.println(users);
    }

}
