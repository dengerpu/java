package com.ep.test;

import com.ep.TutorsystemApplication;
import com.ep.domain.Notice;
import com.ep.domain.Student;
import com.ep.service.NoticeService;
import com.ep.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorsystemApplication.class)
public class NoticeTest {
    @Autowired
    private NoticeService noticeService;

    /*
     * 测试按照用户名查找用户信息
     * */
    @Test
    public void testsaveuser(){
        Notice notice = new Notice();

        notice.setAuthor("管理员");
        notice.setTitle("测试");
        notice.setContent("测试内容");

        noticeService.saveNotice(notice);

    }


    /*
     * 测试按照用户名查找用户信息
     * */
    @Test
    public void testFindStudentByUsername(){
        List<Notice> allNotice = noticeService.findAllNotice("", 1, 10);
        for (Notice notice: allNotice){
            System.out.println(notice);
        }
    }

    /*
     * 测试查找用户总数
     * */
    @Test
    public void testFindTotalTeacher(){
        int totalNotice = noticeService.findTotalNotice("");

        System.out.println(totalNotice);
    }
    /*
     * 测试根据id查询用户
     * */
    @Test
    public void testFindTeacherById(){
        Notice noticeById = noticeService.findNoticeById(1);
        System.out.println(noticeById);
    }

    /*
     * 测试根据id删除用户
     * */
    @Test
    public void testDeleteUserById(){
        noticeService.deleteNoticeById(1);
    }
    /*
     * 测试根更新用户
     * */
    @Test
    public void testUpdateUserById(){

        Notice notice = new Notice();

        notice.setId(1);
        notice.setAuthor("管理员");
        notice.setTitle("测试");
        notice.setContent("测试内容");

        noticeService.updateStudentById(notice);

    }
}
