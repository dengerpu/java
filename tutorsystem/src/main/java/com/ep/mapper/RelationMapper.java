package com.ep.mapper;

import com.ep.domain.QuotaBean;
import com.ep.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RelationMapper {

    /*
    * 插入学生和老师对应关系
    * */
    @Insert("insert into st_relationship(tid,sid) values (#{tid},#{sid})")
    public void saveStudentAndTutorRelationship(@Param("tid") int tid, @Param("sid") int sid);

    /*
    * 查找对应老师和学生的关系
    * */
    @Select("select * from st_relationship where tid = #{tid} and sid = #{sid}")
    public QuotaBean findRelationship(@Param("tid") int tid, @Param("sid") int sid);

    /*
    * 学生的关系
    * */
    @Delete("delete from st_relationship where sid = #{sid}")
    public void deleteRelationshipBytid(int sid);

    /*
     * 删除老师和学生的关系
     * */
    @Delete("delete from st_relationship where sid = #{sid} and tid = #{tid}")
    public void deleteRelationshipBytidAndSid(@Param("sid") int sid,@Param("tid") int tid);

    /*
    * 查找老师招生名额
    * */
    @Select("select quota from teacher where id = #{id}")
    public int findQuotaById(int id);

    /*
    * 查询老师已经招生名额
    * */
    @Select("SELECT COUNT(*) FROM st_relationship r WHERE r.tid = #{tid}")
    public int findAlreadyQuota(int tid);

    /*
    * 查找老师辅导的学生
    * */
    @Select("SELECT s.* FROM st_relationship st \n" +
            "LEFT JOIN teacher t ON st.`tid` = t.id\n" +
            "LEFT JOIN student s ON s.id = st.`sid`\n" +
            "WHERE t.id = #{tid} AND s.name like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Student> findMyStudent(@Param("tid") int tid,@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

}
