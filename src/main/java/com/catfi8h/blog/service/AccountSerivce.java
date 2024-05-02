package com.catfi8h.blog.service;

import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountSerivce {
	
	private final AccountRepository accountRepository;
	
	public void createAccount(Account account) {}
}
