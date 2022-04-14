package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.User;
import com.ep.service.StudentService;
import com.ep.service.TeacherService;
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
public class StudentTest {

    @Autowired
    private StudentService studentService;

    /*
     * 测试按照用户名查找用户信息
     * */
    @Test
    public void testsaveuser(){
        Student student = new Student();

        student.setUsername("123456");
        student.setName("张三");
        student.setCollege("软件学院");
        student.setMajor("软件工程");
        student.setEmail("123456@qq.com");
        student.setPhone("18239026314");
        student.setHonor("河南优秀教师");
        student.setInterest("软件开发");

        studentService.saveStudent(student);
    }


    /*
    * 测试按照用户名查找用户信息
    * */
    @Test
    public void testFindStudentByUsername(){
       String username = "123456";

        Student student = studentService.findStudentByUsername(username);
        System.out.println(student);
    }

    /*
     * 测试查找所有用户
     * */
    @Test
    public void testFindAllUser(){
        List<Student> allStudent = studentService.findAllStudent("", 1, 10);
        for(Student u: allStudent){
            System.out.println(u);
        }
    }

    /*
     * 测试查找用户总数
     * */
    @Test
    public void testFindTotalTeacher(){
        int totalStudent = studentService.findTotalStudent("");

        System.out.println(totalStudent);
    }
    /*
     * 测试根据id查询用户
     * */
    @Test
    public void testFindTeacherById(){
        Student studentById = studentService.findStudentById(1);
        System.out.println(studentById);
    }

    /*
     * 测试根据id删除用户
     * */
    @Test
    public void testDeleteUserById(){
        studentService.deleteStudentById(2);
    }
    /*
     * 测试根更新用户
     * */
    @Test
    public void testUpdateUserById(){

        Student student = new Student();
        student.setId(1);
        student.setUsername("123456");
        student.setName("张三");
        student.setCollege("软件学院");
        student.setMajor("软件工程");
        student.setEmail("123456@qq.com");
        student.setPhone("18239026314");
        student.setHonor("河南优秀教师");
        student.setInterest("软件开发");
        student.setSex("男");

        studentService.updateStudentById(student);
    }
}
