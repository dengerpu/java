package com.ep.controller;

import com.ep.domain.GrowthPlan;
import com.ep.domain.PageBean;
import com.ep.domain.ResultInfo;
import com.ep.domain.User;
import com.ep.service.UserService;
import com.ep.utils.MailUtils;
import com.ep.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private UserService userService;
    /*
     * 发送邮箱验证码
     * */
    @RequestMapping(value = "/findpassword",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo findPassword(String username,String email,String type, HttpServletResponse response, HttpServletRequest request){

        // 获取到session
        HttpSession session = request.getSession();
        // 取到sessionid
        String id = session.getId();

        User user = userService.findUserByUsernameAndEmail(username, email, type);
        ResultInfo info = new ResultInfo();
        if (user == null) {
            info.setStatus(400);
            info.setMsg("信息有误");
        }else{
            //生成随机的6位数密码
            String code = RandomUtil.getCode();
            String text = "【导师制下的学生成长管理系统】尊敬的"+user.getUsername()+"用户，您正在找回登录密码，验证码:"+code+"，如非本人操作，请注意账号安全。切勿将验证码泄露于他人，5分钟内有效。";
            try {
                MailUtils.sendMail(user.getEmail(),text,"找回密码");
                // 将验证码存入Session
                session.setAttribute("SESSION_CODE_" + id, code);
                session.setMaxInactiveInterval(60*5);//设置过期时间
                info.setStatus(200);
                info.setMsg("发送验证码成功");
            }catch (Exception e){
                System.out.println(e);
                info.setStatus(401);
                info.setMsg("发送验证码失败");
            }
        }
        return info;
    }
    /**
     * 修改密码
     */
    @RequestMapping(value = "/findpassword",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo updatePassword(@RequestBody User user,HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        String type = user.getType();
        String email = user.getEmail();
        String code = user.getCode();

        HttpSession session = request.getSession();
        String id = session.getId();

        ResultInfo resultInfo = new ResultInfo();


        // 将session中的取出对应session id生成的验证码
        String serverCode = (String) session.getAttribute("SESSION_CODE_" + id);
//        System.out.println("username:"+username);
//        System.out.println("serverCode:"+serverCode);
//        System.out.println("code:"+code);
//        System.out.println(code.equals(serverCode));
        // 校验验证码
        if(serverCode==null){
            resultInfo.setStatus(401);
            resultInfo.setMsg("验证码失效");
            return resultInfo;
        }
        if (null == code || !(code.equals(serverCode))) {
            resultInfo.setStatus(402);
            resultInfo.setMsg("验证码错误");
            return resultInfo;
        }
        try{
            userService.updatePasswordByEmail(username, email, type, password);
            session.removeAttribute("SESSION_CODE_" + id);
            // 这里做具体业务相关
            resultInfo.setStatus(200);
            resultInfo.setMsg("修改密码成功");
            return resultInfo;

        }catch (Exception e){
            resultInfo.setStatus(403);
            resultInfo.setMsg("修改密码失败");
            return resultInfo;
        }

    }

    /*
     * 管理员发布邮箱通知，发送给所有用户啊
     * */
    @RequestMapping(value = "/sendusers",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo sendAllUser(String title){

        //获取所有人的邮箱
        ResultInfo info = new ResultInfo();

        try {
            List<String> allUserEmail = userService.findAllUserEmail();
            String text = "【导师制下的学生成长管理系统】：管理员发布了《"+title+"》的通知，请及时登陆网站查看。";
            for (String email:allUserEmail){
                if (email!=null||email!=""){
                    MailUtils.sendMail(email,text,"通知");
                }

            }
            info.setMsg("发送成功");
            info.setStatus(200);
        }catch (Exception e){
            System.out.println(e);
            info.setStatus(400);
            info.setMsg("发送失败");
        }
        return info;
    }
    /*
     * 老师发布邮箱通知，只发送给自己的学生
     * */
    @RequestMapping(value = "/sendmystudent",method = {RequestMethod.GET})
    @ResponseBody
    public ResultInfo sendMyStudentEmail(String title,int tid){

        //获取所有人的邮箱
        ResultInfo info = new ResultInfo();

        try {
            List<String> allUserEmail = userService.findMyStudentmail(tid);
            String text = "【导师制下的学生成长管理系统】：您的导师发布了《"+title+"》的通知，请及时登陆网站查看。";
            for (String email:allUserEmail){
                if (email!=null||email!=""){
                    MailUtils.sendMail(email,text,"通知");
                }
            }
            info.setMsg("发送成功");
            info.setStatus(200);
        }catch (Exception e){
            System.out.println(e);
            info.setStatus(400);
            info.setMsg("发送失败");
        }
        return info;
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updateemail",method = {RequestMethod.POST})
    @ResponseBody
    public ResultInfo updateEmail(@RequestBody User user,HttpServletRequest request) {
        String username = user.getUsername();
        String newEmail = user.getNewEmail();
        String code = user.getCode();

        HttpSession session = request.getSession();
        String id = session.getId();

        ResultInfo resultInfo = new ResultInfo();


        // 将session中的取出对应session id生成的验证码
        String serverCode = (String) session.getAttribute("SESSION_CODE_" + id);

        // 校验验证码
        if(serverCode==null){
            resultInfo.setStatus(401);
            resultInfo.setMsg("验证码失效");
            return resultInfo;
        }
        if (null == code || !(code.equals(serverCode))) {
            resultInfo.setStatus(402);
            resultInfo.setMsg("验证码错误");
            return resultInfo;
        }
        try{
            userService.updateEmail(username,newEmail);
            session.removeAttribute("SESSION_CODE_" + id);
            // 这里做具体业务相关
            resultInfo.setStatus(200);
            resultInfo.setMsg("修改邮箱成功");
            return resultInfo;

        }catch (Exception e){
            resultInfo.setStatus(403);
            resultInfo.setMsg("修改密码失败");
            return resultInfo;
        }

    }
}
