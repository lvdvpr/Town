package com.town.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterForm {

    @Pattern(regexp = "^[a-z][a-z0-9]{2,11}$", message = "아이디를 영문(소문자), 숫자를 이용하여 3~12자리로 공백없이 입력하세요. 단, 시작은 영소문자만 가능하며, 숫자로만 이루어진 아이디는 사용할 수 없습니다.")
    private String id;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호를 영문(대/소문자), 숫자, 특수문자를 조합하여 공백없이 8~16자리로 입력하세요.")
    private String password;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호를 영문(대/소문자), 숫자, 특수문자를 조합하여 공백없이 8~16자리로 입력하세요.")
    private String passwordConfirm;
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,12}$", message = "닉네임을 영문(대/소문자), 한글을 이용하여 공백없이 2~12자리로 입력하세요.")
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "연락처는 필수 입력값입니다.")
    private String phone;
    private String zipcode;
    private String basicAddress;
    private String detailAddress;
    private String roleName;
}
