package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.service.StudentService;
import com.ep.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorsystemApplication.class)
public class TeacherTest {

    @Autowired
    private TeacherService teacherService;

    /*
     * 测试按照用户名查找用户信息
     * */
    @Test
    public void testsaveuser(){
        Teacher teacher = new Teacher();

        teacher.setUsername("123456");
        teacher.setName("张三");
        teacher.setCollege("软件学院");
        teacher.setMajor("软件工程");
        teacher.setEmail("123456@qq.com");
        teacher.setPhone("18239026314");
        teacher.setHonor("河南优秀教师");
        teacher.setInterest("软件开发");

        teacherService.saveTeacher(teacher);
    }


    /*
    * 测试按照用户名查找用户信息
    * */
    @Test
    public void testFindStudentByUsername(){
       String username = "123456";

        Teacher teacher = teacherService.findTeacherByUsername(username);
        System.out.println(teacher);
    }

    /*
     * 测试查找所有用户
     * */
    @Test
    public void testFindAllUser(){
        List<Teacher> allTeacher = teacherService.findAllTeacher("", 1, 10);

        for(Teacher u: allTeacher){
            System.out.println(u);
        }
    }

    /*
     * 测试查找用户总数
     * */
    @Test
    public void testFindTotalTeacher(){
        int totalTeacher = teacherService.findTotalTeacher("");

        System.out.println(totalTeacher);
    }
    /*
     * 测试根据id查询用户
     * */
    @Test
    public void testFindTeacherById(){
        Teacher teacher = teacherService.findTeacherById(1);

        System.out.println(teacher);
    }

    /*
     * 测试根据id删除用户
     * */
    @Test
    public void testDeleteUserById(){
        teacherService.deleteTeacherById(2);
    }
    /*
     * 测试根更新用户
     * */
    @Test
    public void testUpdateUserById(){

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setUsername("123456");
        teacher.setName("张三");
        teacher.setCollege("软件学院");
        teacher.setMajor("软件工程");
        teacher.setEmail("123456@qq.com");
        teacher.setPhone("18239026314");
        teacher.setHonor("河南优秀教师");
        teacher.setInterest("软件开发");
        teacher.setSex("男");

        teacherService.updateTeacherById(teacher);
    }
    /*
    * 测试查找老师实际招生名额
    * */
    @Test
    public void testFindAlready(){
        int alreadAdmission = teacherService.findAlreadAdmission(1);
        System.out.println(alreadAdmission);
    }
}
