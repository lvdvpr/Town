package com.town.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("User")
@Data
public class User {

    private int userNo;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String zipcode;
    private String basicAddress;
    private String detailAddress;
    private int isAdmin;
    private String userStatus;
    private Timestamp userCreatedDate;
    private Timestamp userUpdatedDate;
    private Timestamp userDeletedDate;
}
