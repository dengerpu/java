package com.ep.service;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层接口
 * */
@Service
public interface UserService {

    /*
    * 用户登录
    * */
    public User Login(String username,String password,String type);

    /*
    * 用户注册
    * */
    public void saveLoginUser(User user);

    /*
    * 根据用户名查找用户
    * */
    public User findUserByUsername(String username);

    /**
     * 查找学生用户是否存在
     * */
    public Student findStudent(String username);

    /*
    * 查找老师用户
    * */
    public Teacher findTeacher(String username);

    /*
     * 查找所用用户
     * */
    public List<User> findAllUser(String query,int pagenum,int pagesize);

    /*
     * 查询用户总数
     * */
    public int findTotalUser(String query);


    /*
     * 根据id查找用户
     * */
    public User findUserById(int id);


    /*
     * 根据id删除用户
     * */
    public void deleteUserById(int id);

    /**
     * 更新用户
     * */
    public void updateUserById(User user);

    /*
    * 找回密码，根据用户名，邮箱找回密码
    * */
    public User findUserByUsernameAndEmail(String username,String email,String type);

    /*
    * 根据邮箱验证码修改密码
    * */
    public void updatePasswordByEmail(String username,String email,String type,String password);

    /*
    * 查找所有用户邮箱
    * */
    public List<String> findAllUserEmail();

    /*
    * 查找老师对应学生的邮箱
    * */
    public List<String> findMyStudentmail(int tid);

    /*
    * 更改邮箱
    * */
    public void updateEmail(String username,String newEmail);

    /*
    * 更改密码
    * */
    public void updatePassword(String username,String password,String newPassword);
}
