package com.catfi8h.blog.service;

import com.catfi8h.blog.repository.entities.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	
	private final AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Account> accountOptional = accountService.findByEmail(email);
		if (accountOptional.isEmpty()) {
			throw new UsernameNotFoundException(email);
		}
		Account account = accountOptional.get();
		List<SimpleGrantedAuthority> authorities =
				account.getAuthority()
						.stream()
						.map(authority -> new SimpleGrantedAuthority(authority.getName()))
						.collect(Collectors.toList());
		
		return new User(account.getEmail(), account.getPassword(), authorities);
	}
}
