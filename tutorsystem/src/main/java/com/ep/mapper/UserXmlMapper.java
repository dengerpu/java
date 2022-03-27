package com.ep.mapper;

import com.ep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserXmlMapper {
    public List<User> queryUserList();
}
