package com.example.demo02.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySecurityUser extends User {

	private static final long serialVersionUID = 1L;
	
	public MySecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			String emailaddress) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.emailaddress = emailaddress;
	}
	private String emailaddress;

	
	@Override
	public String toString() {
		return "MySecurityUser emailaddress=" + emailaddress + "] " + super.toString();
	}
	
	
}