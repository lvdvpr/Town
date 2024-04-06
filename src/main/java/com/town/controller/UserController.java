package com.town.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.town.exception.AlreadyRegisteredEmailException;
import com.town.exception.AlreadyRegisteredUserIdException;
import com.town.request.UserRegisterForm;
import com.town.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/checkUserId")
    public ResponseEntity<String> checkUserId(@RequestParam String userId) {
    	String checkResult = userService.findUser(userId);
    	if ("ok".equals(checkResult)) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }

	@GetMapping("/register")
    public String getRegisterForm(Model model) {
		UserRegisterForm form = new UserRegisterForm();
		model.addAttribute("userRegisterForm", form);

        return "register-form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userRegisterForm") @Valid UserRegisterForm userRegisterForm, BindingResult errors) {
        if (errors.hasErrors()) {
            return "register-form";
        }
        if(!userRegisterForm.getPassword().equals(userRegisterForm.getPasswordConfirm())) {
        	errors.rejectValue("password", null, "비밀번호가 일치하지 않습니다.");
        	errors.rejectValue("passwordConfirm", null, "비밀번호가 일치하지 않습니다.");
        	return "register-form";
        }
        try {
            userService.registerUser(userRegisterForm);
        } catch (AlreadyRegisteredUserIdException ex) {
            errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");	// 회원가입화면에 에러메시지를 띄움
            return "register-form";
        } catch (AlreadyRegisteredEmailException ex) {
            errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
            return "register-form";
        }
        return "redirect:/login";
    }


}
