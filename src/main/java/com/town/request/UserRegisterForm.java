package com.town.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterForm {

    @Pattern(regexp = "^[a-z][a-z0-9]{2,11}$", message = "아이디를 3~12자리 영문(소문자), 숫자로 입력하세요. 단, 시작은 영소문자만 가능합니다.")
    private String id;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호를 8~16자 영문(대/소문자), 숫자, 특수문자를 조합하여 입력하세요.")
    private String password;
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,12}$", message = "닉네임을 2~12자리 영문(대/소문자), 한글로 입력하세요.")
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
