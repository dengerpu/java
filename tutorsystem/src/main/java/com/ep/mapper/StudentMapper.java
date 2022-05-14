package com.ep.mapper;

import com.ep.domain.Student;
import com.ep.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*
*
* 学生持久层接口
* */
@Mapper
@Repository
public interface StudentMapper {


    /*
     * 保存学生
     * */
    @Insert("insert into student(username,name,age,sex,college,major,email,phone,interest,image,introduce,honor) values (#{username},#{name},#{age},#{sex},#{college},#{major},#{email},#{phone},#{interest},#{image},#{introduce},#{honor})")
    public void saveStudent(Student student);

    /*
     * 根据用户名查找学生
     * */
    @Select("select * from student where username = #{username}")
    public Student findStudentByUsername(String username);

    /*
     * 根据姓名查找学生
     * */
    @Select("select * from student where name = #{name}")
    public Student findStudentByName(String name);

    /*
     * 查找所有学生
     * */

    @Select("select * from student where username like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Student> findAllStudent(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
     * 查找学生总数
     * */

    @Select("select count(*) from student where username like concat('%',#{query},'%')")
    public int findTotalStudent(String query);


    /*
     * 根据id查找学生
     * */
    @Select("select * from student where id = #{id}")
    public Student findStudentById(int id);

    /*
     * 根据id删除学生，先删除申请记录
     * */
    @Delete("delete from applation_records where sid = #{id}")
    public void deleteApplicationBySID(int id);
    /*
     * 根据id删除学生，再删除关系
     * */
    @Delete("delete from st_relationship where sid = #{id}")
    public void deleteRelationShipById(int id);

    /*
     * 根据id删除学生
     * */
    @Delete("delete from student where id = #{id}")
    public void deleteStudentById(int id);

    /**
     * 更新用户
     * */
    @Update("update student set username = #{username},name = #{name},sex = #{sex},age = #{age},college = #{college},major = #{major},email = #{email},phone = #{phone},interest = #{interest},image = #{image},introduce = #{introduce},honor = #{honor} where id = #{id}")
    public void updateUserById(Student student);

    /*
    * 查找学生以及对应的导师
    * */
    @Select("SELECT s.*,t.name turtor FROM student s \n" +
            "LEFT JOIN st_relationship r \n" +
            "ON r.sid = s.id \n" +
            "LEFT JOIN teacher t\n" +
            "ON r.tid = t.id where s.username like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Student> findAllStudentAndTutor(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
    * 根据id查找学生，以及对应的老师姓名
    * */
    @Select("SELECT s.*,t.`name` turtor FROM student s\n" +
            "LEFT JOIN st_relationship st ON st.sid = s.`id`\n" +
            "LEFT JOIN teacher t ON t.id = st.`tid`\n" +
            "WHERE s.id = #{id}")
    public Student findStudentAndTnameByID(int id);

    /*
    * 根据学院和专业查找学生
    * */
    @Select("select * from student where college = #{college} and major = #{major} limit #{start}, #{pagesize}")
    public List<Student> findAllStudentByCollegeAndMajor(@Param("college") String college,@Param("major") String major,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
    * 根据学院查找学生
    * */
    @Select("select * from student where college = #{college} limit #{start}, #{pagesize}")
    public List<Student> findAllStudentByCollege(@Param("college") String college,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
    * 根据用户名查找id
    * */
    @Select("select id from student where username = #{username}")
    public int findStudentId(String username);
}
