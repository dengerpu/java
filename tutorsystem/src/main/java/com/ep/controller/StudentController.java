package com.ep.controller;


import com.ep.domain.PageBean;
import com.ep.domain.ResultInfo;
import com.ep.domain.Student;
import com.ep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
* 学生控制类
* */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
     * 查找所有用户
     * */
    @RequestMapping(value = "/students",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllUser(String query,int pagenum,int pagesize){

        List<Student> allStudent = studentService.findAllStudent(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allStudent);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = studentService.findTotalStudent(query);
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
        if(allStudent.size()==0){
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
     * 查找所有用户
     * */
    @RequestMapping(value = "/stuandtea",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllStudenAndTurtor(String query,int pagenum,int pagesize){

        List<Student> allStudent = studentService.findAllStudentAndTutor(query, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allStudent);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = studentService.findTotalStudent(query);
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
        if(allStudent.size()==0){
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
     * 根据学院和专业查找所有学生和导师
     * */
    @RequestMapping(value = "/stus",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllStudenByCollegeAndMajor(String college,String major,int pagenum,int pagesize){

        List<Student> allStudent = studentService.findAllStudentByCollegeAndMajor(college,major, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allStudent);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = studentService.findTotalStudent("");
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
        if(allStudent.size()==0){
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
     * 根据学院查找所有学生和导师
     * */
    @RequestMapping(value = "/stu",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindAllStudentByCollege(String college,int pagenum,int pagesize){

        List<Student> allStudent = studentService.findAllStudentByCollege(college, pagenum, pagesize);
        PageBean pageBean = new PageBean();
        pageBean.setList(allStudent);   //用户表
        pageBean.setCurrentPage(pagenum);//当前页数
        int total = studentService.findTotalStudent("");
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
        if(allStudent.size()==0){
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
     * 用户注册
     * */
    @RequestMapping(value = "/students",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo AddStudent(@RequestBody Student student){

        //先查询用户名是否存在
        Student stu = studentService.findStudentByUsername(student.getUsername());
        ResultInfo info = new ResultInfo();

        if(stu!=null){
            info.setStatus(400);
            info.setMsg("用户已存在");
        }else if(stu==null) {
            studentService.saveStudent(student);
            info.setStatus(200);
            info.setMsg("保存成功");
        }
        return info;
    }

    /*
     * 根据id查找用户
     * */
    @RequestMapping(value = "/editstudent",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneStudent(int id){

        Student student = studentService.findStudentById(id);

        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(student==null){
            info.setStatus(400);
            info.setMsg("用户不存在");
        }else{
            info.setData(student);
            info.setStatus(200);
            info.setMsg("查找成功");
        }

        return info;
    }

    /*
     * 根据id修改用户
     * */
    @RequestMapping(value = "/editstudent",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo  EditOneStudent(@RequestBody Student student){

        ResultInfo info = new ResultInfo();
        try{
            studentService.updateStudentById(student);
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
    @RequestMapping(value = "/deletestudent",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  DeleteOneStudent(int id){

        ResultInfo info = new ResultInfo();
        try{
            studentService.deleteApplicationBySID(id);
            studentService.deleteRelationShipById(id);
            studentService.deleteStudentById(id);
            info.setStatus(200);
            info.setMsg("删除成功");

        }catch (Exception e){
            info.setStatus(400);
            info.setMsg("删除失败");
        }
        return info;
    }
    /*
    * 根据用户名查找id
    * */
    @RequestMapping(value = "/getsid",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo  GetSId(String username){

        ResultInfo info = new ResultInfo();
        try{
            int id = studentService.findStudentId(username);
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
     * 根据id查找学生以及指导老师姓名
     * */
    @RequestMapping(value = "/findstudent",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindOneStudentAndTname(int id){

        Student student = studentService.findStudentAndTnameById(id);
        //System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(student==null){
            info.setStatus(400);
            info.setMsg("用户不存在");
        }else{
            info.setData(student);
            info.setStatus(200);
            info.setMsg("查找成功");
        }
        return info;
    }
    /*
     * 查找学生总数
     * */
    @RequestMapping(value = "/findtotalstu",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo FindTotalStudent( ){

        ResultInfo info = new ResultInfo();
        try{
            int totalStudent = studentService.findTotalStudent("");
            info.setMsg("查询成功");
            info.setStatus(200);
            info.setData(totalStudent);

        }catch (Exception e){
            System.out.println(e);
            info.setMsg("查找失败");
            info.setStatus(400);
        }

        return info;
    }

}
