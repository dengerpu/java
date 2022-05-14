package com.ep.controller;

import com.ep.domain.*;
import com.ep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /*
     * 查找所有老师
     * */
    @RequestMapping(value = "/teachers",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllTeacher(String query, int pagenum, int pagesize){

        List<Teacher> allTeacher = teacherService.findAllTeacher(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allTeacher);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = teacherService.findTotalTeacher(query);
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
        if(allTeacher.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }
    /*
     * 查找所有老师已经对应的已招生名额
     * */
    @RequestMapping(value = "/teas",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllTeacherAndAlready(String query, int pagenum, int pagesize){

        List<Teacher> allTeacher = teacherService.findAllTeacherAndAlready(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allTeacher);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = teacherService.findTotalTeacher(query);
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
        if(allTeacher.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }
    /*
     * 根据学院和专业查找导师分页查询
     * */
    @RequestMapping(value = "/tearslimit",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllStudenByCollegeLimit(String college,int pagenum,int pagesize){

        List<Teacher> allTeacher = teacherService.findAllTeacherByCollegeLimit(college, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allTeacher);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = teacherService.findCountTeacherByCollege(college);
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
        if(allTeacher.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(pageBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }
    /*
     * 根据学院和专业查找导师
     * */
    @RequestMapping(value = "/tearname",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllTeacherName(String username){

        TeacherBean teacherBean = new TeacherBean();
        teacherBean = teacherService.findTeacherNameById(username);
        ResultInfo info = new ResultInfo();
        if(teacherBean==null){
            info.setStatus(400);
            info.setMsg("查找作者姓名失败");
        }else{
            info.setData(teacherBean);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 根据学院和专业查找导师
     * */
    @RequestMapping(value = "/tears",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllStudenByCollege(String college){

        List<Teacher> allTeacher = teacherService.findAllTeacherByCollege(college);
        ResultInfo info = new ResultInfo();
        if(allTeacher.size()==0){
            info.setStatus(400);
            info.setMsg("无用户");
        }else{
            info.setData(allTeacher);
            info.setStatus(200);
            info.setMsg("请求成功");
        }
        return info;
    }

    /*
     * 老师注册
     * */
    @RequestMapping(value = "/teachers",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddTecher(@RequestBody Teacher teacher){

        //先查询老师是否存在
        Teacher t = teacherService.findTeacherByUsername(teacher.getUsername());

        ResultInfo info = new ResultInfo();

        if(t!=null){
            info.setStatus(400);
            info.setMsg("用户已存在");
        }else if(t==null) {
            teacherService.saveTeacher(teacher);
            info.setStatus(200);
            info.setMsg("保存成功");
        }
        return info;
    }

    /*
     * 根据id查找老师
     * */
    @RequestMapping(value = "/editteacher",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneTeacher(int id){

        Teacher teacher = teacherService.findTeacherById(id);

        ResultInfo info = new ResultInfo();
        if(teacher==null){
            info.setStatus(400);
            info.setMsg("用户不存在");
        }else{
            info.setData(teacher);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改用户
     * */
    @RequestMapping(value = "/editteacher",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOneTeacher(@RequestBody Teacher teacher){

        ResultInfo info = new ResultInfo();
        try{
            teacherService.updateTeacherById(teacher);
            info.setStatus(200);
            info.setMsg("修改成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("修改失败");
        }
        return info;
    }

    /*
     * 根据id删除老师
     * */
    @RequestMapping(value = "/deleteteacher",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOneStudent(int id){

        ResultInfo info = new ResultInfo();
        try{
            teacherService.deleteApplicationBySID(id);
            teacherService.deleteRelationShipById(id);
            teacherService.deleteTeacherById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }
    /*
     * 根据id修改老师招生名额
     * */
    @RequestMapping(value = "/editquota",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  GETTeacherQuota(int tid){

        ResultInfo info = new ResultInfo();
        try{
            int quota = teacherService.findTeacherQuota(tid);
            info.setStatus(200);
            info.setMsg("查找名额失败");
            info.setData(quota);

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("查找名额成功");
        }
        return info;
    }


    /*
     * 根据id修改老师招生名额
     * */
    @RequestMapping(value = "/editquota",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditTeacherQuota(@RequestBody QuotaBean bean){
        int id = bean.getId();
        int quota = bean.getQuota();
        ResultInfo info = new ResultInfo();
        int already = teacherService.findAlreadAdmission(id);
        System.out.println(already);
        if(quota<already){
            info.setStatus(400);
            info.setMsg("分配名额失败：小于已录名额");
        }else{
            teacherService.updateTeancherQuota(id,quota);
            info.setStatus(200);
            info.setMsg("分配名额成功");
        }
        return info;
    }
    /*
     * 根据用户名查找id
     * */
    @RequestMapping(value = "/gettid",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  GetSId(String username){

        ResultInfo info = new ResultInfo();
        try{
            int id = teacherService.findTid(username);
            info.setStatus(200);
            info.setData(id);
            info.setMsg("查找成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("查找失败");
        }
        return info;
    }
    /*
     * 查找老师总数
     * */
    @RequestMapping(value = "/findtotaltea",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindTotalStudent( ){

        ResultInfo info = new ResultInfo();
        try{
            int totalTeacher = teacherService.findTotalTeacher("");
            info.setMsg("查询成功");
            info.setStatus(200);
            info.setData(totalTeacher);

        }catch (Exception e){
            System.out.println(e);
            info.setMsg("查找失败");
            info.setStatus(400);
        }

        return info;
    }
}
