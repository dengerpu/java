package com.ep.service.impl;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.TeacherBean;
import com.ep.mapper.TeacherMapper;
import com.ep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherMapper.saveTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        Teacher teacher = teacherMapper.findTeacherByUsername(username);
        return teacher;
    }

    @Override
    public List<Teacher> findAllTeacher(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Teacher> allTeacher = teacherMapper.findAllTeacher(query, start, pagesize);
        return allTeacher;
    }

    @Override
    public int findTotalTeacher(String query) {
        int totalTeacher = teacherMapper.findTotalTeacher(query);
        return totalTeacher;
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher = teacherMapper.findTeacherById(id);
        return teacher;
    }
    /*
     * 根据id删除老师，先删除申请记录
     * */
    @Override
    public void deleteApplicationBySID(int id) {
        teacherMapper.deleteApplicationBySID(id);
    }

    /*
     * 根据id删除老师，第2步删除关系
     * */
    @Override
    public void deleteRelationShipById(int id) {
        teacherMapper.deleteRelationShipById(id);
    }

    /*
    * 根据id删除老师
    * */
    @Override
    public void deleteTeacherById(int id) {
        teacherMapper.deleteTeacherById(id);
    }

    @Override
    public void updateTeacherById(Teacher teacher) {
        teacherMapper.updateTeacherById(teacher);
    }

    /**
     * 根据id查找老师姓名
     * */
    @Override
    public TeacherBean findTeacherNameById(String username) {
        TeacherBean teacherNameByTid = teacherMapper.findTeacherNameByTid(username);
        return teacherNameByTid;
    }

    /*
    * 查找老师招生名额
    * */
    @Override
    public int findTeacherQuota(int tid) {
        int teacherQuota = teacherMapper.findTeacherQuota(tid);
        return teacherQuota;
    }

    /*
    * 更改老师招生名额
    * */
    @Override
    public void updateTeancherQuota(int id, int quota) {
        teacherMapper.updateTeacherQuota(id,quota);
    }

    @Override
    public int findAlreadAdmission(int id) {
        //System.out.println(id);
        int i = teacherMapper.findAlreadyAdmission(id);
        return i;
    }

    /*
    * 查找老师和对应的已招生人数
    * */
    @Override
    public List<Teacher> findAllTeacherAndAlready(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Teacher> allTeacherAndAlready = teacherMapper.findAllTeacherAndAlready(query, start, pagesize);
        return allTeacherAndAlready;
    }

    /**
     *根据学院查找老师分页查询
     */
    @Override
    public List<Teacher> findAllTeacherByCollegeLimit(String college, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Teacher> allTeacher = teacherMapper.findAllTeacherByCollegeLimit(college, start, pagesize);
        return allTeacher;
    }

    /*
    * 根据学院查找老师
    * */
    @Override
    public List<Teacher> findAllTeacherByCollege(String college) {
        List<Teacher> allTeacher = teacherMapper.findAllTeacherByCollege(college);
        return allTeacher;
    }

    /*
    * 根据学院查找老师个数
    * */
    @Override
    public int findCountTeacherByCollege(String college) {
        int countTeacherByCollege = teacherMapper.findCountTeacherByCollege(college);
        return countTeacherByCollege;
    }
    /*
    * 根据用户名查找老师id
    * */

    @Override
    public int findTid(String username) {
        int tid = teacherMapper.findTid(username);
        return tid;
    }

}
