package com.town.service;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private final BCryptPasswordEncoder passwordEncoder;

	public String findUser(String userId) {
		Optional<User> savedUser = Optional.ofNullable(userMapper.getUserById(userId));
		if (savedUser.isEmpty()) {
			return "ok";
		} else {
			return "no";
		}
	}

    public void registerUser(UserRegisterForm userRegisterForm) {
    	Optional<User> savedUser = Optional.ofNullable(userMapper.getUserById(userRegisterForm.getId()));
        if (savedUser.isPresent()) {
            throw new AlreadyRegisteredUserIdException("["+userRegisterForm.getId()+"] 이미 사용중인 아이디입니다.");
        }
        savedUser = Optional.ofNullable(userMapper.getUserByEmail(userRegisterForm.getEmail()));
        if (savedUser.isPresent()) {
            throw new AlreadyRegisteredEmailException("["+userRegisterForm.getEmail()+"] 이미 사용중인 이메일입니다.");
        }
        User.UserBuilder builder = new User.UserBuilder(userRegisterForm.getId(), passwordEncoder.encode(userRegisterForm.getPassword()), userRegisterForm.getName(),
        		userRegisterForm.getEmail(), userRegisterForm.getPhone(), userRegisterForm.getRoleName());
        builder.zipcode(userRegisterForm.getZipcode())
        	   .basicAddress(userRegisterForm.getBasicAddress())
        	   .detailAddress(userRegisterForm.getDetailAddress());
        User user = builder.build();

        userMapper.insertUser(user);
    }
}
