package com.example.demo02.controller.privates;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo02.dto.AuthorityDto;
import com.example.demo02.service.AuthorityServce;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ManagerController {

	private final AuthorityServce authorityServce;

	@GetMapping("/authorities")
	public String getauthorities(Model model) {
		List<AuthorityDto> authorities = authorityServce.getAllAuthorities();
		model.addAttribute("title", "Athorities");
		model.addAttribute("authorities", authorities);
		return "authorities";
	}

	@GetMapping("/authorities/{id}")
	public AuthorityDto getauthorityById(@PathVariable Integer id) {
		return authorityServce.getAuthorityById(id);
	}
}