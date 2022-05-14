package com.ep.mapper;

import com.ep.domain.Student;
import com.ep.domain.Teacher;
import com.ep.domain.TeacherBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TeacherMapper {

    /*
     * 保存老师
     * */
    @Insert("insert into teacher(username,name,age,sex,college,major,email,phone,interest,image,introduce,honor) values (#{username},#{name},#{age},#{sex},#{college},#{major},#{email},#{phone},#{interest},#{image},#{introduce},#{honor})")
    public void saveTeacher(Teacher teacher);

    /*
     * 根据用户名查找老师
     * */
    @Select("select * from teacher where username = #{username}")
    public Teacher findTeacherByUsername(String username);

    /*
     * 根据姓名查找老师
     * */
    @Select("select * from teacher where name = #{name}")
    public Teacher findTeacherByName(String name);

    /*
     * 查找所有老师
     * */

    @Select("select * from teacher where username like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Teacher> findAllTeacher(@Param("query") String query, @Param("start") int start, @Param("pagesize") int pagesize);

    /*
     * 查找学生总数
     * */

    @Select("select count(*) from teacher where username like concat('%',#{query},'%')")
    public int findTotalTeacher(String query);


    /*
    * 根据工号查找老师姓名
    * */
    @Select("select id,name from teacher where username = #{username}")
    public TeacherBean findTeacherNameByTid(String usernmae);


    /*
     * 根据id查找老师
     * */
    @Select("select * from teacher where id = #{id}")
    public Teacher findTeacherById(int id);
    /*
     * 根据id删除老师，先删除申请记录
     * */
    @Delete("delete from applation_records where tid = #{id}")
    public void deleteApplicationBySID(int id);
    /*
     * 根据id删除老师，再删除关系
     * */
    @Delete("delete from st_relationship where tid = #{id}")
    public void deleteRelationShipById(int id);
    /*
     * 根据id删除老师
     * */
    @Delete("delete from teacher where id = #{id}")
    public void deleteTeacherById(int id);

    /**
     * 更新用户
     * */
    @Update("update teacher set username = #{username},name = #{name},sex = #{sex},college = #{college},major = #{major},email = #{email},phone = #{phone},interest = #{interest},image = #{image},introduce = #{introduce},honor = #{honor},age = #{age} where id = #{id}")
    public void updateTeacherById(Teacher teacher);

    /*
    * 更改招生名额
    * */
    @Update("update teacher set quota = #{quota} where id = #{id}")
    public void updateTeacherQuota(@Param("id") Integer id,@Param("quota") int quota);

    /*
     * 查找招生名额
     * */
    @Select("select teacher.quota from teacher where id = #{tid}")
    public int findTeacherQuota(int tid);

    /*
    * 查找已录名额
    * */
    @Select("select count(*) from st_relationship where tid = #{id}")
    public int findAlreadyAdmission(int id);

    /*
    * 查找老师已经对应的已招生名额
    * */
    @Select("SELECT t.*,(SELECT COUNT(*) FROM st_relationship r WHERE r.tid = t.id) already\n" +
            "FROM teacher t where username like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Teacher> findAllTeacherAndAlready(@Param("query") String query, @Param("start") int start, @Param("pagesize") int pagesize);

    /*
    * 根据学院专业查找老师分页查询
    * */
    @Select("select * from teacher where college = #{college} limit #{start}, #{pagesize}")
    public List<Teacher> findAllTeacherByCollegeLimit(@Param("college") String college,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
    * 根据学院专业查找老师
    * */
    @Select("select * from teacher where college = #{college}")
    public List<Teacher> findAllTeacherByCollege(@Param("college") String college);

    /*
    * 根据专业查询老师人数
    * */
    @Select("select count(*) from teacher where college = #{college}")
    public int findCountTeacherByCollege(@Param("college") String college);

    /*
    * 根据用户名查找老师id
    * */
    @Select("select id from teacher where username = #{username}")
    public int findTid(String username);
}
