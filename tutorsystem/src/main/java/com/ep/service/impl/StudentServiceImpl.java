package com.ep.service.impl;

import com.ep.domain.Student;
import com.ep.mapper.StudentMapper;
import com.ep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /*
    * 保存用户
    * */
    @Override
    public void saveStudent(Student student) {
        studentMapper.saveStudent(student);
    }

    /*
    * 根据学号查找姓名
    * */
    @Override
    public Student findStudentByUsername(String username) {
        Student student = studentMapper.findStudentByUsername(username);
        return student;
    }

    /*
    * 查找所有学生
    * */
    @Override
    public List<Student> findAllStudent(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Student> allStudent = studentMapper.findAllStudent(query, start, pagesize);
        return allStudent;
    }

    /*
    *
    * 查找用户次数
    * */
    @Override
    public int findTotalStudent(String query) {
        int totalStudent = studentMapper.findTotalStudent(query);
        return totalStudent;
    }

    /*
    * 根据id查找用户
    * */
    @Override
    public Student findStudentById(int id) {
        Student student = studentMapper.findStudentById(id);
        return student;
    }
    /*
     * 根据id删除学生，先删除申请记录
     * */
    @Override
    public void deleteApplicationBySID(int id) {
        studentMapper.deleteApplicationBySID(id);
    }

    /*
     * 根据id删除学生，第2步删除关系
     * */
    @Override
    public void deleteRelationShipById(int id) {
        studentMapper.deleteRelationShipById(id);
    }

    /*
    * 根据id删除用户
    * */
    @Override
    public void deleteStudentById(int id) {
        studentMapper.deleteStudentById(id);
    }

    @Override
    public void updateStudentById(Student student) {
        studentMapper.updateUserById(student);
    }

    /*
    * 查找对应的学生和导师
    * */
    @Override
    public List<Student> findAllStudentAndTutor(String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Student> allStudent = studentMapper.findAllStudentAndTutor(query, start, pagesize);
        return allStudent;
    }

    /*
    * 根据学院查找学生信息
    * */
    @Override
    public List<Student> findAllStudentByCollege(String college, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Student> allStudentByCollege = studentMapper.findAllStudentByCollege(college, start, pagesize);
        return allStudentByCollege;
    }

    /**
     * 根据学院和专业查找学生信息
     * */
    @Override
    public List<Student> findAllStudentByCollegeAndMajor(String college, String major, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Student> allStudent = studentMapper.findAllStudentByCollegeAndMajor(college, major, start, pagesize);
        return allStudent;
    }

    @Override
    public int findStudentId(String username) {
        int studentId = studentMapper.findStudentId(username);
        return studentId;
    }

    /*
    * 查找学生以及对应的老师姓名
    * */
    @Override
    public Student findStudentAndTnameById(int id) {
        Student studentAndTnameByID = studentMapper.findStudentAndTnameByID(id);
        return studentAndTnameByID;
    }
}
