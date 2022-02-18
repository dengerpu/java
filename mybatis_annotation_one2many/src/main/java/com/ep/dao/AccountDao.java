package com.ep.dao;

import com.ep.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {


    /*
    * 查询所有账户以及对应的用户信息
    * */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.ep.dao.UserDao.FindUserById",fetchType = FetchType.EAGER))
    })
    List<Account> FindAll();

    /*
    * 根据Id查询用户
    * */
    @Select("select * from account where uid = #{userId}")
    List<Account> FindAccountByUID(String userId);

}
