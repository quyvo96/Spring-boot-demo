package com.example.demo02.dto;

import lombok.Builder;

@Builder
public record AuthorityDto(
		Integer id,
		String authority) {}