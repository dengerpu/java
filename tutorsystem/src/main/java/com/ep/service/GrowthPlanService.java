package com.ep.service;

import com.ep.domain.GrowthPlan;
import com.ep.domain.Paper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GrowthPlanService {

    /*
     * 保存计划
     * */
    public void savePlan(GrowthPlan plan);

    /*
     * 根据sid查找计划
     * */
    public GrowthPlan findPlanBySid(int sid);


    /*
     * 根据id查找计划
     * */
    public GrowthPlan findPlanById(int id);

    /*
     * 根据id删除计划
     * */
    public void deletePlanById(int id);

    /*
     * 根据sid删除计划
     * */
    public void deletePlanBySid(int sid);

    /**
     * 更新计划
     * */
    public void updatePlanById(GrowthPlan plan);
}
