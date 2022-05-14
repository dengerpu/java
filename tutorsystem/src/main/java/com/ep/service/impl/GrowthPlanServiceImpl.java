package com.ep.service.impl;

import com.ep.domain.GrowthPlan;
import com.ep.domain.Paper;
import com.ep.mapper.GrowthPlanMapper;
import com.ep.service.GrowthPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GrowthPlanServiceImpl implements GrowthPlanService {

    @Autowired
    private GrowthPlanMapper growthPlanMapper;

    @Override
    public void savePlan(GrowthPlan plan) {
        growthPlanMapper.savePlan(plan);
    }

    @Override
    public GrowthPlan findPlanBySid(int sid) {
        GrowthPlan planBySid = growthPlanMapper.findPlanBySid(sid);
        return planBySid;
    }

    @Override
    public GrowthPlan findPlanById(int id) {
        GrowthPlan planById = growthPlanMapper.findPlanById(id);
        return planById;
    }

    @Override
    public void deletePlanById(int id) {
        growthPlanMapper.deletePlanById(id);
    }

    @Override
    public void deletePlanBySid(int sid) {
        growthPlanMapper.deletePlanBySid(sid);
    }

    @Override
    public void updatePlanById(GrowthPlan plan) {
        growthPlanMapper.updatePlanById(plan);
    }
}
