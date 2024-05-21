package com.catfi8h.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public static PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((auth) -> {
					auth
							.requestMatchers("/", "/login", "/register", "/h2-console/*").permitAll()
							.requestMatchers(antMatcher(HttpMethod.GET, "/post/*")).permitAll()
							.anyRequest().authenticated();
				});
		
		http
				.formLogin(form -> form
						                   .loginPage("/login")
						                   .loginProcessingUrl("/login")
						                   .usernameParameter("email")
						                   .passwordParameter("password").defaultSuccessUrl("/", true)
						                   .failureForwardUrl("/login?error=true")
						                   .permitAll()
				).logout(form -> form
						                 .logoutUrl("/logout")
						                 .logoutSuccessUrl("/"))
				.httpBasic(Customizer.withDefaults());
		
		//TODO remove when not need H2-CONSOLE
		http.csrf(AbstractHttpConfigurer::disable);
		http.headers(e -> e.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
		return http.build();
	}
}
