package com.example.demo02.controller.publics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
	

	@GetMapping("/wellcome")
	public String home(Model model) {
		model.addAttribute("title", "Hello!!!");
		model.addAttribute("message", "123!!");
		return "hello";
	}


}