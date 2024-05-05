package com.catfi8h.blog.controller.thymeleaf;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.service.AccountSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegisterController {
	
	private final AccountSerivce accountSerivce;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("account", new AccountDto());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@ModelAttribute AccountDto account) {
		account.setRole("Admin");
		accountSerivce.createAccount(account);
		return "redirect:/login";
	}
}
