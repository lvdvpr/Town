package com.town.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.town.vo.User;

@Mapper
public interface UserMapper {
    User getUserById(String id);
    void insertUser(User user);
    User getUserByEmail(String email);
}
