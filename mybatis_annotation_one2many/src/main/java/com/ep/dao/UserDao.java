package com.ep.dao;

import com.ep.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

/*
*  mybatis注解配置,CRUD操作，一共有4个注解
*  @Select   @Insert @Update  @Delete
* */
//开启二级缓存
@CacheNamespace(blocking = true)
public interface UserDao {


    /*
    * 查询所有用户
    * */
    @Select("select * from user")
    @Results( id = "userMap",
            value ={
                    @Result( id = true, column = "id",property = "userId"),
                    @Result(column = "username",property = "userName"),
                    @Result(column = "address",property = "userAddress"),
                    @Result(column = "sex",property = "userSex"),
                    @Result(column = "birthday",property = "userBirthday"),
                    @Result(column = "id",property = "accounts",
                            many = @Many(select = "com.ep.dao.AccountDao.FindAccountByUID",fetchType = FetchType.LAZY)
                    )
            }
    )
    List<User> findAll();

    /**
     * 增加用户
     * */
    @Insert("insert into user(username,sex,address,birthday) values (#{username},#{sex},#{address},#{birthday})")
    void SaveUser(User user);

    /**
     * 更新用户
     * */
    @Update("update user set username = #{username},sex=#{sex},address=#{address},birthday=#{birthday} where id = #{id}")
    void UpdateUser(User user);

    /*
    * 删除用户
    * */
    @Delete("delete from user where id = #{id}")
    void DeleteUser(Integer userId);

    /*
    * 根据id查询
    * */
    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User FindUserById(Integer id);

    /*
    * 测试根据姓名模糊查询
    * */
   // @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> FindUserByName(String username);

    /*
     * 查询总条数
     * */
    @Select("select count(*) from user")
    Integer FindCountUser();

}
