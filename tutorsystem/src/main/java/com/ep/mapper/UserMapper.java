package com.ep.mapper;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.User;
import org.apache.ibatis.annotations.*;
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

     /*
     * 查找学生用户是否存在
     * */
     @Select("select * from student where username = #{username}")
     public Student findUserNameByUsernameStudent(String username);

     /*
      * 查找老师用户是否存在
      * */
     @Select("select * from teacher where username = #{username}")
     public Teacher findUserNameByUsernameTeacher(String username);

     /*
     * 查找所用用户
     * */

     @Select("select * from user where username like concat('%',#{query},'%') limit #{start}, #{pagesize}")
     public List<User> findAllUser(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

      /*
       * 查找用户总数
       * */

      @Select("select count(*) from user where username like concat('%',#{query},'%')")
      public int findTotalUser(String query);


      /*
     * 根据id查找用户
     * */
     @Select("select * from user where id = #{id}")
     public User findUserById(int id);

     /*
     * 根据id删除用户
     * */
     @Delete("delete from user where id = #{id}")
     public void deleteUserById(int id);

     /**
      * 更新用户
      * */
     @Update("update user set username = #{username},password = #{password},email = #{email},phone = #{phone},type = #{type},status = #{status} where id = #{id}")
     public void updateUserById(User user);

     /*
     * 找回密码：根据账号，邮箱类型
     * */
     @Select("select * from user where username = #{username} and email = #{email} and type = #{type}")
     public User findUserByusernameAndEmail(@Param("username") String username,@Param("email") String email,@Param("type") String type);

     /*
     * 更改密码
     * */
     @Update("update user set password = #{password} where username = #{username} and email = #{email} and type = #{type}")
     public void updateUserPasswordByEmail(@Param("username") String username,@Param("email") String email,@Param("type") String type,@Param("password") String password);

     /*
     * 更改邮箱
     * */
     @Update("update user set email = #{newEmail} where username = #{username}")
     public void updateEmail(@Param("username") String username,@Param("newEmail") String newEmail);

     /**
      * 更改密码
      * */
     @Update("update user set password = #{newPassword} where username = #{username} and password = #{password}")
     public void updatePassword(@Param("username") String username,@Param("password") String password,@Param("newPassword") String newPassword);

     /*
     * 查找其他用户的邮箱，除了管理员
     * */
     @Select("select email from user where type!='admin'")
     public List<String> findAllUserEmail();


      /*
       * 查找老师辅导的学生的邮箱
       * */
      @Select("SELECT s.email FROM st_relationship st \n" +
              "LEFT JOIN teacher t ON st.`tid` = t.id\n" +
              "LEFT JOIN student s ON s.id = st.`sid`\n" +
              "WHERE t.id = #{tid}")
      public List<String> findMyStudentEmail(int tid);

 }
