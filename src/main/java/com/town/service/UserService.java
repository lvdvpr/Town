package com.town.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.town.exception.AlreadyRegisteredEmailException;
import com.town.exception.AlreadyRegisteredUserIdException;
import com.town.mapper.UserMapper;
import com.town.request.UserRegisterForm;
import com.town.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserMapper userMapper;

    public void registerUser(UserRegisterForm userRegisterForm) {
        User savedUser = userMapper.getUserById(userRegisterForm.getId());
        if (savedUser != null) {
            throw new AlreadyRegisteredUserIdException("["+userRegisterForm.getId()+"] 이미 사용중인 아이디입니다.");
        }
        savedUser = userMapper.getUserByEmail(userRegisterForm.getEmail());
        if (savedUser != null) {
            throw new AlreadyRegisteredEmailException("["+userRegisterForm.getEmail()+"] 이미 사용중인 이메일입니다.");
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);   // userRegisterForm의 변수명과 user의 변수명이 같으면 복사된다.
        userMapper.insertUser(user);
    }
}
