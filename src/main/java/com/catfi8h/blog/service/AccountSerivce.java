package com.catfi8h.blog.service;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.controller.mapper.SimpleAccountMapper;
import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountSerivce {
	
	private final AccountRepository accountRepository;
	private final SimpleAccountMapper simpleAccountMapper;
	
	public void createAccount(AccountDto dto) {
		Account account = simpleAccountMapper.dtoToAccount(dto);
		accountRepository.save(account);
	}
	
	public AccountDto getAccountById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()){
			Optional<AccountDto> accountDto = account.map(e -> simpleAccountMapper.accountToDto(e));
			AccountDto accountDto1 = accountDto.get();
			return accountDto1;
			
		}else {
			return null;
		}
	}
	
	public Optional<AccountDto> findByEmail(String email) {
		Optional<Account> accountOpt = accountRepository.findOneByEmail(email);
		return accountOpt.map(simpleAccountMapper::accountToDto);
	}
}
