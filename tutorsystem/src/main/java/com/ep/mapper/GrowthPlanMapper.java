package com.ep.mapper;

import com.ep.domain.GrowthPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/*
* 成长计划持久层
* */
@Mapper
@Repository
public interface GrowthPlanMapper {

    /*
     * 保存计划
     * */
    @Insert("insert into growthplan(sid,tid,username,plan,create_time,update_time,dateline,direction) values (#{sid},#{tid},#{username},#{plan},#{create_time},#{update_time},#{dateline},#{direction})")
    public void savePlan(GrowthPlan plan);

    /*
     * 根据sid查找计划
     * */
    @Select("select * from growthplan where sid = #{sid}")
    public GrowthPlan findPlanBySid(int sid);

    /*
     * 根据id计划
     * */
    @Select("select * from growthplan where id = #{id}")
    public GrowthPlan findPlanById(int id);

    /*
     * 根据id删除计划
     * */
    @Delete("delete from growthplan where id = #{id}")
    public void deletePlanById(int id);


    /*
     * 根据sid删除计划
     * */
    @Delete("delete from growthplan where sid = #{sid}")
    public void deletePlanBySid(int sid);

    /**
     * 更新计划
     * */
    @Update("update growthplan set plan = #{plan},update_time = #{update_time},direction = #{direction} where id = #{id}")
    public void updatePlanById(GrowthPlan plan);
}
