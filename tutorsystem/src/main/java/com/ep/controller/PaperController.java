package com.ep.controller;

import com.ep.domain.Notice;
import com.ep.domain.PageBean;
import com.ep.domain.Paper;
import com.ep.domain.ResultInfo;
import com.ep.service.NoticeService;
import com.ep.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.PAData;

import java.util.List;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    /*
     * 查找所有论文
     * */
    @RequestMapping(value = "/papers",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllPaper(String query, int pagenum, int pagesize){

        List<Paper> allPaper = paperService.findAllPaper(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allPaper);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = paperService.findTotalPaper(query);
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
        if(allPaper.size()==0){
            info.setStatus(400);
            info.setMsg("无提交的论文");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 发表论文
     * */
    @RequestMapping(value = "/papers",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddPaper(@RequestBody Paper paper){

        ResultInfo info = new ResultInfo();
        try{
            paperService.savePaper(paper);
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
     * 根据id查找论文
     * */
    @RequestMapping(value = "/editpaper",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOnePaper(int id){


        Paper paperById = paperService.findPaperById(id);

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(paperById==null){
            info.setStatus(400);
            info.setMsg("论文不存在");
        }else{
            info.setData(paperById);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改论文
     * */
    @RequestMapping(value = "/editpaper",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOnePaper(@RequestBody Paper paper){

        ResultInfo info = new ResultInfo();
        try{
            paperService.updatePaperById(paper);
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
    @RequestMapping(value = "/deletepaper",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOnePaper(int id){

        ResultInfo info = new ResultInfo();
        try{
            paperService.deletePaperById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }

    /*
     * 根据sid查找论文
     * */
    @RequestMapping(value = "/papper",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindPaperBySid(int sid,String query,int pagenum,int pagesize){

        List<Paper> allPaper = paperService.findPaperBySid(sid, query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allPaper);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total =  paperService.findTotalPaperBySid(query, sid);
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
        if(allPaper.size()==0){
            info.setStatus(400);
            info.setMsg("无论文");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 根据tid查找论文
     * */
    @RequestMapping(value = "/tidpapper",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindPaperByTid(int tid,String query,int pagenum,int pagesize){

        List<Paper> allPaper = paperService.findPaperByTid(query, pagenum, pagesize, tid);
        PageBean pageBean = new PageBean();
        pageBean.setList(allPaper);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total =  paperService.findTotalByTid(query, tid);
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
        if(allPaper.size()==0){
            info.setStatus(400);
            info.setMsg("无论文");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

}
