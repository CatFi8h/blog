package com.catfi8h.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((auth) -> {
					auth
						.requestMatchers("/","/login", "/register","/h2-console/*").permitAll()
						.requestMatchers(antMatcher(HttpMethod.GET, "/post/*")).permitAll()
						.anyRequest().authenticated();
				});
		//TODO remove when not need H2-CONSOLE
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
