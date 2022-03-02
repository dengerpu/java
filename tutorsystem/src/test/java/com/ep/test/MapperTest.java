package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.User;
import com.ep.mapper.UserMapper;
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


    @Test
    public void test() {
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }

}
