package com.example.demo02.service.register;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo02.entities.User;
import com.example.demo02.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {
	
	private final UserRepository userRepository;

	public boolean register(User user) {
		Optional<User> userCheck = userRepository.getByUsername(user.getUsername());
		if (userCheck.isEmpty()) {
			userRepository.save(user);
			return true;
		}
		return false;
	}
}
