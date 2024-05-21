package com.catfi8h.blog.service;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.controller.mapper.SimpleAccountMapper;
import com.catfi8h.blog.repository.AuthorityRepository;
import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.AccountRepository;
import com.catfi8h.blog.repository.entities.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	private final SimpleAccountMapper simpleAccountMapper;
	private final AuthorityRepository authorityRepository;
	private final PasswordEncoder passwordEncoder;
	
	public void createAccount(AccountDto dto) {
		Account account = simpleAccountMapper.dtoToAccount(dto);
		Set<Authority> authorities = new HashSet<>();
		authorityRepository.findByName(dto.getRole()).ifPresent(authorities::add);
		account.setAuthority(authorities);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
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
	
	public Optional<AccountDto> findDtoByEmail(String email) {
		Optional<Account> accountOpt = accountRepository.findOneByEmail(email);
		return accountOpt.map(simpleAccountMapper::accountToDto);
	}
	public Optional<Account> findByEmail(String email) {
		return accountRepository.findOneByEmail(email);
	}
}
