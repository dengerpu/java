package com.ep.service;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.TeacherBean;

import java.util.List;

/*
* 教师业务层接口
* */
public interface TeacherService {
    /*
     * 老师注册
     * */
    public void saveTeacher(Teacher teacher);

    /*
     * 根据用户名查找老师
     * */
    public Teacher findTeacherByUsername(String username);

    /*
     * 查找所用老师
     * */
    public List<Teacher> findAllTeacher(String query, int pagenum, int pagesize);

    /*
     * 查询老师总数
     * */
    public int findTotalTeacher(String query);


    /*
     * 根据id查找老师
     * */
    public Teacher findTeacherById(int id);

    /*
     * 根据id删除老师，先删除申请记录
     * */
    public void deleteApplicationBySID(int id);
    /*
     * 根据id删除老师，再删除关系
     * */
    public void deleteRelationShipById(int id);
    /*
     * 根据id删除老师
     * */
    public void deleteTeacherById(int id);

    /**
     * 更新老师
     * */
    public void updateTeacherById(Teacher teacher);

    /*
    * 根据工号查找老师姓名
    * */
    public TeacherBean findTeacherNameById(String username);


    /*
    * 查找老师招生名额
    * */
    public int findTeacherQuota(int tid);

    /*
    更改老师招生名额
    * */
    public void updateTeancherQuota(int id,int quota);

    /*
    * 查找老师实际学生名额
    * */
    public int findAlreadAdmission(int id);

    /*
    * 查找老师已经对应的已招生名额
    * */
    public List<Teacher> findAllTeacherAndAlready(String query, int pagenum, int pagesize);

    /*
    * 根据学院查找老师分页查询
    * */
    public List<Teacher> findAllTeacherByCollegeLimit(String college, int pagenum, int pagesize);

    /*
    * 根据学院查找老师
    * */
    public List<Teacher> findAllTeacherByCollege(String college);

    /*
    * 根据专业查找老师个数
    * */
    public int findCountTeacherByCollege(String college);

    /**
     * 根据用户名查找老师id
     * */
    public int findTid(String username);
}
