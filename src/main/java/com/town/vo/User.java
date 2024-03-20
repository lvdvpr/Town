package com.town.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Getter;

@Alias("User")
@Getter
public class User {

    private final int userNo;
    private final String id;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;
    private final String zipcode;
    private final String basicAddress;
    private final String detailAddress;
    private final String isAdmin;
    private final String userStatus;
    private final Timestamp userCreatedDate;
    private final Timestamp userUpdatedDate;
    private final Timestamp userDeletedDate;

    private User(UserBuilder builder) {
    	this.userNo = builder.userNo;
    	this.id = builder.id;
    	this.password = builder.password;
    	this.name = builder.name;
    	this.email = builder.email;
    	this.phone = builder.phone;
    	this.zipcode = builder.zipcode;
    	this.basicAddress = builder.basicAddress;
    	this.detailAddress = builder.detailAddress;
    	this.isAdmin = builder.isAdmin;
    	this.userStatus = builder.userStatus;
    	this.userCreatedDate = builder.userCreatedDate;
    	this.userUpdatedDate = builder.userUpdatedDate;
    	this.userDeletedDate = builder.userDeletedDate;
    }

    public static class UserBuilder {
    	private int userNo;
    	private final String id;
    	private String password;
    	private String name;
    	private String email;
        private String phone;
        private String zipcode;
        private String basicAddress;
        private String detailAddress;
        private String isAdmin;
        private String userStatus;
        private Timestamp userCreatedDate;
        private Timestamp userUpdatedDate;
        private Timestamp userDeletedDate;

        public UserBuilder(String id, String password, String name, String email, String phone) {
        	this.id = id;
           	this.password = password;
        	this.name = name;
        	this.email = email;
        	this.phone = phone;
        }
        public UserBuilder userNo(int userNo) {
        	this.userNo = userNo;
        	return this;
        }
        public UserBuilder zipcode(String zipcode) {
        	this.zipcode = zipcode;
        	return this;
        }
        public UserBuilder basicAddress(String basicAddress) {
        	this.basicAddress = basicAddress;
        	return this;
        }
        public UserBuilder detailAddress(String detailAddress) {
        	this.detailAddress = detailAddress;
        	return this;
        }
        public UserBuilder isAdmin(String isAdmin) {
        	this.isAdmin = isAdmin;
        	return this;
        }
        public UserBuilder userStatus(String userStatus) {
        	this.userStatus = userStatus;
        	return this;
        }
        public UserBuilder userCreatedDate(Timestamp userCreatedDate) {
        	this.userCreatedDate = userCreatedDate;
        	return this;
        }
        public UserBuilder userUpdatedDate(Timestamp userUpdatedDate) {
        	this.userUpdatedDate = userUpdatedDate;
        	return this;
        }
        public UserBuilder userDeletedDate(Timestamp userDeletedDate) {
        	this.userDeletedDate = userDeletedDate;
        	return this;
        }
        public User build() {
        	return new User(this);
        }
    }

}
