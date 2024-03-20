package com.town.service;

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
        User.UserBuilder builder = new User.UserBuilder(userRegisterForm.getId(), userRegisterForm.getPassword(), userRegisterForm.getName(),
        		userRegisterForm.getEmail(), userRegisterForm.getPhone());
        builder.zipcode(userRegisterForm.getZipcode())
        	   .basicAddress(userRegisterForm.getBasicAddress())
        	   .detailAddress(userRegisterForm.getDetailAddress());
        User user = builder.build();

        userMapper.insertUser(user);
    }
}
