package com.example.demo02.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo02.entities.User;
import com.example.demo02.service.register.RegisterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	private final RegisterService registerService;

	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("AA" + passwordEncoder.encode("123"));
		model.addAttribute("title", "Login");
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		System.out.println("AA" + passwordEncoder.encode("123"));
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", "Register");
		model.addAttribute("message", "");
		return "register";
	}

	@PostMapping("/register/success")
	public String register(@ModelAttribute("user") User user, Model model) {
		User userRegister = User.builder().username(user.getUsername())
				.password(passwordEncoder.encode(user.getPassword())).emailAddress(user.getEmailAddress()).build();
		if( registerService.register(userRegister) ) {
			model.addAttribute("message", "Register OK!!!");
			return "/success";
		}
		model.addAttribute("user", new User());
		model.addAttribute("message", "Register error!!!");
		return "/register";
		
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("loginError", true);
		return "login";
	}
}
