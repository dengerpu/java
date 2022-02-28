package com.ep.controller;

import com.ep.domain.Account;
import com.ep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 控制层
* */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String testfindAll(Model model){
        System.out.println("表现层:查询方法执行了");
        List<Account> accounts = accountService.findAllAccount();
        model.addAttribute("accounts",accounts);
//        for (Account account:accounts){
//            System.out.println(account);
//        }
        return "list";
    }

    @RequestMapping("/save")
    public void testSave(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层:保存方法执行了");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return ;
    }

}
