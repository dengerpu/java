package com.ep.dao;

import com.ep.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 持久层接口
* */
@Repository
public interface AccountDao {

    //查询所有用户
    @Select("select * from account")
    List<Account> findAllAccount();

    //保存用户
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);
}
