package com.example.demo02.controller.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo02.dto.UserDto;
import com.example.demo02.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserDto> users = userService.getAllUsers();
		model.addAttribute("title", "Users");
		model.addAttribute("users", users);
		return "users";
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
}