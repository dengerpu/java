package com.ep.dao;

import com.ep.domain.Role;

import java.util.List;

public interface RoleDao {

    /*
    * 查询所有角色
    * */
    List<Role> findAll();
}
