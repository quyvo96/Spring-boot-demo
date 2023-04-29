package com.example.demo02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo02.dto.UserDto;
import com.example.demo02.entities.User;
import com.example.demo02.mapper.UserMapper;
import com.example.demo02.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserDto getLoginUser() {
		return userMapper.userEntityToDto(userRepository.findLoginUser().orElse(null));
	}
	
	public UserDto getUserById(Integer id) {
		return userMapper.userEntityToDto(userRepository.findById(id).orElse(null));
	}
	
	public List<UserDto> getAllUsers() {
		return userMapper.userListEntityToDto(userRepository.findAll());
	}
	
	public UserDto createUser(User user) {
		return userMapper.userEntityToDto(userRepository.save(user));
	}
	

	public UserDto updateUser(User user) {
		return userMapper.userEntityToDto(userRepository.save(user));
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);;
	}
	
}