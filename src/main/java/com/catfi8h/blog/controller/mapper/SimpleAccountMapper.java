package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.entities.Role;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Component
public class SimpleAccountMapper {
	
	public Account dtoToAccount(AccountDto dto) {
		
		Account account = new Account();
		account.setEmail(dto.getEmail());
		account.setUsername(dto.getUsername());
		account.setFirstName(dto.getFirstName());
		account.setLastName(dto.getLastName());
		account.setPassword(dto.getPassword());
		Role role = new Role();
		role.setName(dto.getRole());
		account.setRole(role);
		return account;
	}
	
	public AccountDto accountToDto(Account account) {
		Role role = account.getRole();
		AccountDto accountDto = new AccountDto(
				account.getEmail(),
				account.getUsername(),
				account.getFirstName(),
				account.getLastName(),
				account.getPassword(),
				role.getName());
		return accountDto;
	}
	
	
	
	
	
}
