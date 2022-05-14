package com.ep.controller;


import com.ep.domain.PageBean;
import com.ep.domain.QuotaBean;
import com.ep.domain.ResultInfo;
import com.ep.domain.Student;
import com.ep.service.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RelationshipController {

    @Autowired
    private RelationShipService relationShipService;

    /*
    * 查找是否已经存在
    * */
    @RequestMapping(value = "/relationship",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo findRelationShip(int tid,int sid){

        QuotaBean relationShip = relationShipService.findRelationShip(tid, sid);
        ResultInfo info = new ResultInfo();

        if(relationShip!=null){
            info.setStatus(400);
            info.setMsg("导师和该同学已建立导师关系");
        }else if(relationShip==null) {

            info.setStatus(200);
            info.setMsg("成功");
       }
        return info;
    }


    /*
     * 保存老师和学生的关系
     * */
    @RequestMapping(value = "/relationship",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo findRelationShipPost(@RequestBody QuotaBean bean){
        int tid = bean.getTid();
        int sid = bean.getSid();
        QuotaBean relationShip = relationShipService.findRelationShip(tid, sid);
        int total = relationShipService.findTeacherQuota(tid);//老师的招生名额
        int already = relationShipService.findAlreadyQuota(tid);//实际招生名额
        ResultInfo info = new ResultInfo();
        if(relationShip!=null){
            info.setStatus(400);
            info.setMsg("导师和该同学已建立导师关系");
        }else if(relationShip==null) {
            if(total==already){
                info.setStatus(401);
                info.setMsg("该老师招生名额已满");
            }else if(already<total){
                //先删除这个同学原有的关系
                relationShipService.deleteRelationshipBySid(sid);
                relationShipService.SaveRelationShip(tid,sid);
                info.setStatus(200);
                info.setMsg("成功");
            }
        }
        return info;
    }
    /*
     * 查找所有用户
     * */
    @RequestMapping(value = "/mystudent",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllMyStudent(int tid,String query,int pagenum,int pagesize){

        List<Student> myStudent = relationShipService.findMyStudent(tid, query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(myStudent);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = relationShipService.findAlreadyQuota(tid);
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
        if(myStudent.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }
}
