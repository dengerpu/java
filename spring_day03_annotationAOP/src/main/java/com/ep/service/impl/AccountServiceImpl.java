package com.ep.service.impl;

import com.ep.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("保存用户");
    }

    public void uodateAccount(int i) {
        System.out.println("更新用户"+i);
    }

    public int deleteAccount() {
        System.out.println("删除用户");
        return 0;
    }
}
