package com.ep.controller;

import com.ep.domain.GrowthPlan;
import com.ep.domain.PageBean;
import com.ep.domain.Paper;
import com.ep.domain.ResultInfo;
import com.ep.service.GrowthPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GrowthPlanController {
    @Autowired
    private GrowthPlanService growthPlanService;

    /*
     * 保存计划
     * */
    @RequestMapping(value = "/plan",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddPlan(@RequestBody GrowthPlan plan){

        int sid = plan.getSid();
        GrowthPlan planById = growthPlanService.findPlanBySid(sid);
        ResultInfo info = new ResultInfo();
        if(planById==null){
            try{
                growthPlanService.savePlan(plan);
                info.setStatus(200);
                info.setMsg("成功");
            }catch (Exception e){
                System.out.println(e);
                info.setStatus(400);
                info.setMsg("失败");
            }
        }else{
            info.setStatus(401);
            info.setMsg("已存在计划");
        }

        return info;
    }

    /*
     * 根据sid查找计划
     * */
    @RequestMapping(value = "/sidplan",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOnePlan(int sid){
        GrowthPlan planBySid = growthPlanService.findPlanBySid(sid);

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(planBySid==null){
            info.setStatus(400);
            info.setMsg("计划不存在");
        }else{
            info.setData(planBySid);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }
    /*
     * 根据sid删除计划
     * */
    @RequestMapping(value = "/delplan",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo DeleteOnePlanBySid(int sid){
        ResultInfo info = new ResultInfo();
        try{
            growthPlanService.deletePlanBySid(sid);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }
    /*
     * 根据id查找计划
     * */
    @RequestMapping(value = "/editplan",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOnePlanById(int id){
        GrowthPlan planById = growthPlanService.findPlanById(id);

        ResultInfo info = new ResultInfo();
        if(planById==null){
            info.setStatus(400);
            info.setMsg("计划不存在");
        }else{
            info.setData(planById);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改计划
     * */
    @RequestMapping(value = "/editplan",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOnePlan(@RequestBody GrowthPlan plan){

        ResultInfo info = new ResultInfo();
        try{
            growthPlanService.updatePlanById(plan);
            info.setStatus(200);
            info.setMsg("修改成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("修改失败");
        }
        return info;
    }

    /*
     * 根据id删除论文
     * */
    @RequestMapping(value = "/deleteplan",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOnePlan(int id){

        ResultInfo info = new ResultInfo();
        try{
            growthPlanService.deletePlanById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }
}
