package com.ep.controller;

import com.ep.domain.ApplationRecord;
import com.ep.domain.Notice;
import com.ep.domain.PageBean;
import com.ep.domain.ResultInfo;
import com.ep.service.ApplationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApplicationRecordController {

    @Autowired
    private ApplationRecordService applationRecordService;
    /*
     * 查找老师对应的记录
     * */
    @RequestMapping(value = "/records",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllRecord(int tid, int pagenum, int pagesize){

        List<ApplationRecord> allRecord = applationRecordService.findAllRecord(tid, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allRecord);   //用户表

        pageBean.setCurrentPage(pagenum);//当前页数
        int total = applationRecordService.findTotal();
        pageBean.setTotalCount(total);   //总数据数
        pageBean.setPageSize(pagesize);  //每页显示条数
        int totalPage;
        if(total%pagesize==0){
            totalPage = total / pagesize;
        }else{
            totalPage = total / pagesize+1;
        }
        pageBean.setTotalPage(totalPage);  //总页数

        ResultInfo info = new ResultInfo();
        if(allRecord.size()==0){
            info.setStatus(400);
            info.setMsg("无记录");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 保存记录
     * */
    @RequestMapping(value = "/records",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddRecord(@RequestBody ApplationRecord record){

        int tid = record.getTid();
        int sid = record.getSid();
        System.out.println(record.toString());
        ApplationRecord recordBySidAndTid = applationRecordService.findRecordBySid(sid);
        ResultInfo info = new ResultInfo();
        try{
            if(recordBySidAndTid==null){
                applationRecordService.SaveRecord(record);
                info.setStatus(200);
                info.setMsg("申请成功");
            }else{
                info.setMsg("您已经申请过老师，暂时无法申请");
                info.setStatus(401);
            }

        }catch (Exception e){
            System.out.println(e);
            info.setStatus(400);
            info.setMsg("申请失败");
        }
        return info;
    }



    /*
     * 根据sid查找记录
     * */
    @RequestMapping(value = "/sidrecord",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneRecord(int sid){

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        ApplationRecord recordBySid = applationRecordService.findRecordBySid(sid);
        if(recordBySid==null){
            info.setStatus(400);
            info.setMsg("查找失败");
        }else{
            info.setData(recordBySid);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id查找记录
     * */
    @RequestMapping(value = "/strecord",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  findRecordBySidAndTid(int tid,int sid){

        ResultInfo info = new ResultInfo();
        ApplationRecord recordBySid = applationRecordService.findRecordBySidAndTid(tid, sid);
        if(recordBySid==null){
            info.setStatus(400);
            info.setMsg("查找失败");
        }else{
            info.setData(recordBySid);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id删除记录
     * */
    @RequestMapping(value = "/deleterecord",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOneRecord(int id){

        ResultInfo info = new ResultInfo();
        try{
           applationRecordService.deletRecord(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }
    /*
     * 根据id修改
     * */
    @RequestMapping(value = "/editrecord",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOneNotice(@RequestBody ApplationRecord record){

        ResultInfo info = new ResultInfo();
        try{
            applationRecordService.UpdateRecord(record);
            info.setStatus(200);
            info.setMsg("接受成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("接受失败");
        }
        return info;
    }


}
