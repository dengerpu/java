package com.ep.mapper;

import com.ep.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 通知持久层接口
* */
@Mapper
@Repository
public interface NoticeMapper {
    /*
     * 保存通知
     * */
    @Insert("insert into notice(tid,author,title,content,enclosure,create_time,update_time) values (#{tid},#{author},#{title},#{content},#{enclosure},#{create_time},#{update_time})")
    public void saveNotice(Notice notice);

    /*
     * 根据tid查找通知
     * */
    @Select("select * from notice where tid = #{tid} and title like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Notice> findNoticeByTid(@Param("tid") int tid,@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
     * 查找文章
     * */
    @Select("select * from notice where title like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Notice> findNotice(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);


    /*
     * 查找文章总数
     * */

    @Select("select count(*) from notice where title like concat('%',#{query},'%')")
    public int findTotalNotice(String query);

    /*
    * 根据tid查找文章总数
    * */
    @Select("select count(*) from notice where tid = #{tid} and title like concat('%',#{query},'%')")
    public int findTotalNoticeByTid(String query,int tid);

    /*
     * 根据id查找文章
     * */
    @Select("select * from notice where id = #{id}")
    public Notice findNoticeById(int id);

    /*
     * 根据id删除文章
     * */
    @Delete("delete from notice where id = #{id}")
    public void deleteNoticeById(int id);

    /**
     * 更新文章
     * */
    @Update("update notice set title = #{title},content = #{content},enclosure = #{enclosure},update_time = #{update_time} where id = #{id}")
    public void updateNoticeById(Notice notice);


}
