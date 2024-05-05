package com.catfi8h.blog.config;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.service.AccountSerivce;
import com.catfi8h.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SeeData implements CommandLineRunner {
	
	private final PostService postService;
	private final AccountSerivce accountSerivce;
	
	@Override
	public void run(String... args) throws Exception {
		List<GetPostDto> posts = postService.getAllPosts();
		
		
		if(posts.isEmpty()){
			AccountDto admin = new AccountDto("admin.admin@domain.com",
					"admin",
					"Admin",
					"Admin",
					"password",
						"admin");
			AccountDto user = new AccountDto("user.user@domain.com",
					"user",
					"User",
					"User",
					"password",
						"user");
			accountSerivce.createAccount(admin);
			accountSerivce.createAccount(user);

			InsertPostDto post1 = new InsertPostDto();
			post1.setTitle("Title1");
			post1.setBody("Body1");
			post1.setEmail("admin.admin@domain.com");
			
			InsertPostDto post2 = new InsertPostDto();
			post2.setTitle("Title2");
			post2.setBody("Body2");
			post2.setEmail("user.user@domain.com");
			
			postService.insert(post1);
			postService.insert(post2);
		}
	}
}
