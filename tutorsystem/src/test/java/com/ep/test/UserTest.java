package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.User;
import com.ep.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorsystemApplication.class)
public class UserTest {

    @Autowired
    private UserServiceImpl userService;

    /*
     * 测试按照用户名查找用户信息
     * */
    @Test
    public void testsaveuser(){
        User user = new User();
        user.setUsername("18031110125");
        user.setPassword("12345");
        user.setEmail("123@qq.com");
        user.setPhone("18239026314");
        user.setType("student");
        user.setDate(new Date());
        userService.saveLoginUser(user);
    }


    /*
    * 测试按照用户名查找用户信息
    * */
    @Test
    public void testFindUserByUsername(){
       String username = "admin";
        User user = userService.findUserByUsername(username);
        System.out.println(user);
    }

    /*
     * 测试查找所有用户
     * */
    @Test
    public void testFindAllUser(){
        List<User> allUser = userService.findAllUser("",1,10);
        for(User u: allUser){
            System.out.println(u);
        }
    }

    /*
     * 测试查找用户总数
     * */
    @Test
    public void testFindTotalUser(){
        int totalUser = userService.findTotalUser("");
        System.out.println(totalUser);
    }
    /*
     * 测试根据id查询用户
     * */
    @Test
    public void testFindUserById(){
        User user = userService.findUserById(2);
        System.out.println(user);
    }

    /*
     * 测试根据id删除用户
     * */
    @Test
    public void testDeleteUserById(){
        userService.deleteUserById(4);
    }
    /*
     * 测试根更新用户
     * */
    @Test
    public void testUpdateUserById(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("123@qq.com");
        user.setPhone("18239026314");
        user.setType("admin");
        user.setDate(new Date());
        userService.updateUserById(user);
    }
    /*
    * 查找用户邮箱
    * */
    @Test
    public void testFindAllUserEmail(){
        List<String> allUserEmail = userService.findAllUserEmail();
        for(String email:allUserEmail){
            System.out.println(email);
        }
    }
}
