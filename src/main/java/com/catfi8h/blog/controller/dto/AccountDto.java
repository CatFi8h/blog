package com.catfi8h.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	private String email;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	
	
}
