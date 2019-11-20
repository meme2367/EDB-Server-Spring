package com.example.rest.mapper;

import com.example.rest.model.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    public user getUserById(String id);

    public int insertUser(user user);
}
