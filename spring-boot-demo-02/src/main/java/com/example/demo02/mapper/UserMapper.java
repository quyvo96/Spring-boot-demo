package com.example.demo02.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo02.dto.UserDto;
import com.example.demo02.entities.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserMapper {

	private final AuthorityMapper authorityMapper;
	
	public UserDto userEntityToDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.authorities(authorityMapper.authorityListEntityToDto(user.getAuthorities()))
				.accountNonExpired(user.getAccountNonExpired())
				.accountNonLocked(user.getAccountNonLocked())
				.credentialsNonExpired(user.getCredentialsNonExpired())
				.enabled(user.getEnabled())
				.emailAddress(user.getEmailAddress())
				.build();
	}
	
	public List<UserDto> userListEntityToDto(List<User> users) {
		return users.stream()
				.map(user -> userEntityToDto(user))
				.toList();
	}
	
	public User userDtoToEntity(UserDto user, String password) {
		return User.builder()
				.id(user.id())
				.username(user.username())
				.password(password)
				.authorities(authorityMapper.authorityListDtoToEntity(user.authorities()))
				.accountNonExpired(user.accountNonExpired())
				.accountNonLocked(user.accountNonLocked())
				.credentialsNonExpired(user.credentialsNonExpired())
				.enabled(user.enabled())
				.emailAddress(user.emailAddress())
				.build();
	}

	public List<User> userListDtoToEntity(List<UserDto> users, String password) {
		return users.stream()
				.map(user -> userDtoToEntity(user, password))
				.toList();
	}
}