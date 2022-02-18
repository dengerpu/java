package com.ep.dao;

import com.ep.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/*
*  mybatis注解配置,CRUD操作，一共有4个注解
*  @Select   @Insert @Update  @Delete
* */
public interface UserDao {


    /*
    * 查询所有用户
    * */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 增加用户
     * */
    @Insert("insert into user(username,sex,address,birthday) values (#{username},#{sex},#{address},#{birthday})")
    void SaveUser(User user);

    /**
     * 更新用户
     * */
    @Update("update user set username = #{username},sex=#{sex},address=#{address},birthday=#{birthday} where id = #{id}")
    void UpdateUser(User user);

    /*
    * 删除用户
    * */
    @Delete("delete from user where id = #{id}")
    void DeleteUser(Integer userId);

    /*
    * 根据id查询
    * */
    @Select("select * from user where id = #{id}")
    User FindUserById(Integer id);

    /*
    * 测试根据姓名模糊查询
    * */
   // @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> FindUserByName(String username);

    /*
     * 查询总条数
     * */
    @Select("select count(*) from user")
    Integer FindCountUser();

}
