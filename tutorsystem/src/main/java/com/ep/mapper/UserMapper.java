package com.ep.mapper;

import com.ep.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*
* 用户持久层接口
* */

 @Mapper
 @Repository
public interface UserMapper {

     /*
      * 用户登录
      * 多个参数是需要加上@param
      *
      * */
     @Select("select * from user where username = #{username} and password = #{password} and type = #{type}")
     public User Login(@Param("username") String username, @Param("password")String password, @Param("type") String type);

     /*
     * 用户注册
     * */
     @Insert("insert into user(username,password,email,phone,type,status,date) values (#{username},#{password},#{email},#{phone},#{type},#{status},#{date})")
     public void saveLoginUser(User user);

     /*
     * 根据用户名查找用户
     * */
     @Select("select * from user where username = #{username}")
     public User findUserByUsername(String username);


 }
