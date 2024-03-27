package com.town.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.town.mapper.UserMapper;
import com.town.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		User user = userMapper.getUserById(id);

		System.out.println("출력"+user.getPassword());

		if (user == null) {
			throw new UsernameNotFoundException("계정이 존재하지 않습니다.");
		}
		if ("D".equals(user.getUserStatus())) {
			throw new UsernameNotFoundException("탈퇴된 계정입니다.");
		} else if ("N".equals(user.getUserStatus())) {
			throw new UsernameNotFoundException("휴면 처리된 계정입니다.");
		} else {

			CustomUserDetails userDetails = new CustomUserDetails(
				user.getUserNo(),
				user.getId(),
				user.getPassword(),
				user.getName(),
				user.getEmail(),
				user.getPhone(),
				user.getUserStatus(),
				user.getRoleName()
			);

			return userDetails;
		}


	}

}
