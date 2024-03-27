package com.town.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends LoginUser implements UserDetails{

	private static final long serialVersionUID = -6938260432438689398L;

	public CustomUserDetails(int userNo, String id, String password, String name,
			String email, String phone, String userStatus, String roleName) {
		super(userNo, id, password, name, email, phone, userStatus, roleName);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(getRoleName()));
	}

	@Override
	public String getPassword() {
		return getEncryptPassword();
	}

	@Override
	public String getUsername() {
		return getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
