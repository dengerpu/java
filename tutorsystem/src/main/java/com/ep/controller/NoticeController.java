package com.ep.controller;

import com.ep.domain.Notice;
import com.ep.domain.PageBean;
import com.ep.domain.ResultInfo;
import com.ep.domain.Student;
import com.ep.service.NoticeService;
import com.ep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /*
     * 查找所有文章
     * */
    @RequestMapping(value = "/notices",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllNotice(String query, int pagenum, int pagesize){

        List<Notice> allNotice = noticeService.findAllNotice(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allNotice);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = noticeService.findTotalNotice(query);
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
        if(allNotice.size()==0){
            info.setStatus(400);
            info.setMsg("无通知");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 发表文章
     * */
    @RequestMapping(value = "/notices",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddNotice(@RequestBody Notice notice){


        ResultInfo info = new ResultInfo();
        try{
            noticeService.saveNotice(notice);
            info.setStatus(200);
            info.setMsg("发表成功");
        }catch (Exception e){
            System.out.println(e);
            info.setStatus(400);
            info.setMsg("失败");
        }
        return info;
    }

    /*
     * 根据id查找文章
     * */
    @RequestMapping(value = "/editnotice",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneNotice(int id){

        Notice noticeById = noticeService.findNoticeById(id);

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(noticeById==null){
            info.setStatus(400);
            info.setMsg("通知不存在");
        }else{
            info.setData(noticeById);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改文章
     * */
    @RequestMapping(value = "/editnotice",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOneNotice(@RequestBody Notice notice){

        ResultInfo info = new ResultInfo();
        try{
            noticeService.updateStudentById(notice);
            info.setStatus(200);
            info.setMsg("修改成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("修改失败");
        }
        return info;
    }

    /*
     * 根据id删除用户
     * */
    @RequestMapping(value = "/deletenotice",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOneStudent(int id){

        ResultInfo info = new ResultInfo();
        try{
            noticeService.deleteNoticeById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }

    /*
     * 根据tid查找文章
     * */
    @RequestMapping(value = "/tnotice",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindNoticeByTid(int tid,String query,int pagenum,int pagesize){

        List<Notice> allNotice = noticeService.findNoticeByTid(tid, query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allNotice);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = noticeService.findTotalNoticeByTid(query, tid);
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
        if(allNotice.size()==0){
            info.setStatus(400);
            info.setMsg("无通知");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 发表文章并以邮件形式发
     * */
    @RequestMapping(value = "/emails",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo SendNoticeByMail(@RequestBody Notice notice){

        ///如果是管理员发布的通知，将发送给所有用户

        ResultInfo info = new ResultInfo();
        try{
            noticeService.saveNotice(notice);
            info.setStatus(200);
            info.setMsg("发表成功");
        }catch (Exception e){
            System.out.println(e);
            info.setStatus(400);
            info.setMsg("失败");
        }
        return info;
    }
}
