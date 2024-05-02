package com.catfi8h.blog.config;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeeData implements CommandLineRunner {
	@Autowired
	private PostService postService;
	
	@Override
	public void run(String... args) throws Exception {
		List<GetPostDto> posts = postService.getAllPosts();
		if(posts.size()>0){
			InsertPostDto post1 = new InsertPostDto();
			post1.setTitle("Title1");
			post1.setBody("Body1");
			
			InsertPostDto post2 = new InsertPostDto();
			post2.setTitle("Title2");
			post2.setBody("Body2");
			
			postService.insert(post1);
			postService.insert(post2);
		}
	}
}
