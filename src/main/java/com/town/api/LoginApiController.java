package com.town.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.town.request.LoginForm;
import com.town.service.UserService;
import com.town.vo.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginApiController {

	private final UserService userService;
	private final BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/api/login")
	public ResponseEntity<User> login(@RequestBody LoginForm form) {
		User savedUser = userService.getUserById(form.getId());
		if (savedUser == null || !passwordEncoder.matches(form.getPassword(), savedUser.getPassword())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}
}
