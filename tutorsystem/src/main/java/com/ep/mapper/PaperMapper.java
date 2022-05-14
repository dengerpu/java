package com.ep.mapper;

import com.ep.domain.Notice;
import com.ep.domain.Paper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 论文持久层
* */
@Mapper
@Repository
public interface PaperMapper {
    /*
     * 保存论文
     * */
    @Insert("insert into paper(sid,author,title,content,enclosure,create_time,update_time,type) values (#{sid},#{author},#{title},#{content},#{enclosure},#{create_time},#{update_time},#{type})")
    public void savePaper(Paper paper);

    /*
     * 根据sid查找论文
     * */
    @Select("select * from paper where sid = #{sid} and title like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Paper> findPaperBySid(@Param("sid") int sid, @Param("query") String query, @Param("start") int start, @Param("pagesize") int pagesize);

    /*
     * 查找论文
     * */
    @Select("select * from paper where title like concat('%',#{query},'%') limit #{start}, #{pagesize}")
    public List<Paper> findPaper(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize);

    /*
     * 查找论文总数
     * */
    @Select("select count(*) from paper where title like concat('%',#{query},'%')")
    public int findTotalPaper(String query);

    /*
     * 根据sid查找论文总数
     * */
    @Select("select count(*) from paper where sid = #{sid} and title like concat('%',#{query},'%')")
    public int findTotalPaperBySid(@Param("query") String query,@Param("sid") int sid);

    /*
     * 根据id查找论文
     * */
    @Select("select * from paper where id = #{id}")
    public Paper findPaperById(int id);

    /*
     * 根据id删除论文
     * */
    @Delete("delete from paper where id = #{id}")
    public void deletePaperById(int id);

    /**
     * 更新论文
     * */
    @Update("update paper set title = #{title},content = #{content},enclosure = #{enclosure},update_time = #{update_time},type = #{type} where id = #{id}")
    public void updatePaperById(Paper paper);

    /*
    * 根据tid查找论文
    * */
    @Select("SELECT * FROM paper p\n" +
            "LEFT JOIN st_relationship s\n" +
            "ON p.sid = s.`sid`\n" +
            "WHERE tid = #{tid} and title like concat('%',#{query},'%') limit #{start}, #{pagesize} ")
    public List<Paper> findPaperBytid(@Param("query") String query,@Param("start") int start,@Param("pagesize") int pagesize,@Param("tid") int tid);

    /*
    * 根据tid查找论文总数
    * */
    @Select("SELECT COUNT(*) FROM paper p\n" +
            "LEFT JOIN st_relationship s\n" +
            "ON p.sid = s.`sid`\n" +
            "WHERE tid = #{tid} and title like concat('%',#{query},'%')")
    public int findTotalBytid(@Param("query") String query,@Param("tid") int tid);
}
