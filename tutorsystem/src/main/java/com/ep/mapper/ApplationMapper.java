package com.ep.mapper;

import com.ep.domain.ApplationRecord;
import com.ep.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplationMapper {

    /*
    * 查找申请记录
    * */
    @Select("SELECT a.*,s.name sname,s.major major,s.username susername, t.name tname FROM applation_records a \n" +
            "LEFT JOIN student s ON s.id = a.`sid`\n" +
            "LEFT JOIN teacher t ON t.id = a.`tid`\n" +
            "where tid = #{tid} LIMIT #{start}, #{pagesize}")
    public List<ApplationRecord> findAllReocrd(@Param("tid") int tid,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
    * 添加申请记录
    * */
    @Insert("insert into applation_records(tid,sid,create_time,update_time,is_agree) values (#{tid},#{sid},#{create_time},#{update_time},#{is_agree})")
    public void saveRecord(ApplationRecord applationRecord);

    /*
    * 删除申请记录
    * */
    @Delete("delete from applation_records where id = #{id}")
    public void deleteRecordByid(int id);

    /*
    *根据sid查找申请记录
    * */
    @Select("SELECT a.*,s.name sname,t.name tname FROM applation_records a \n" +
            "LEFT JOIN student s ON s.id = a.`sid`\n" +
            "LEFT JOIN teacher t ON t.id = a.`tid`\n" +
            "where sid = #{sid}")
    public ApplationRecord findRecordBySid(int sid);

    /*
    * 查询记录总数
    * */
    @Select("select count(*) from applation_records")
    public int findAllRecordTotal();

    /*
    * 查找是否有申请记录，如果有
    * */
    @Select("select * from applation_records where tid = #{tid} and sid = #{sid}")
    public ApplationRecord findRecordBySidAndTid(@Param("tid") int tid,@Param("sid") int sid);

    /*
    *更新申请记录
    * */
    @Update("update applation_records set is_agree = #{is_agree},update_time = #{update_time} where id = #{id}")
    public void UpdateRecord(ApplationRecord record);

}
