package com.ep.service;

import com.ep.domain.Student;
import com.ep.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生业务层接口
 * */
@Service
public interface StudentService {

    /*
     * 学生注册
     * */
    public void saveStudent(Student student);

    /*
     * 根据用户名查找学生
     * */
    public Student findStudentByUsername(String username);

    /*
     * 查找所用学生
     * */
    public List<Student> findAllStudent(String query, int pagenum, int pagesize);

    /*
     * 查询学生总数
     * */
    public int findTotalStudent(String query);


    /*
     * 根据id查找学生
     * */
    public Student findStudentById(int id);
    /*
     * 根据id删除学生，先删除申请记录
     * */
    public void deleteApplicationBySID(int id);
    /*
     * 根据id删除学生，再删除关系
     * */
    public void deleteRelationShipById(int id);

    /*
     * 根据id删除学生
     * */
    public void deleteStudentById(int id);

    /**
     * 更新学生
     * */
    public void updateStudentById(Student student);

    /**
     * 查找对应的学生和老师
     * */
    public List<Student> findAllStudentAndTutor(String query, int pagenum, int pagesize);

    /*
    * 根据学院查找
    * */
    public List<Student> findAllStudentByCollege(String college,int pagenum, int pagesize);

    /*
    * 根据学院和专业查找
    * */
    public List<Student> findAllStudentByCollegeAndMajor(String college,String major,int pagenum, int pagesize);

    /*
    * 根据学号查找id
    * */
    public int  findStudentId(String username);

    /*
    * 根据id查找学生以及导师姓名
    * */
    public Student findStudentAndTnameById(int id);
}
