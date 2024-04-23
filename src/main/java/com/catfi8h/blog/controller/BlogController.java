package com.catfi8h.blog.controller;

import com.catfi8h.blog.controller.dto.PostDTO;
import com.catfi8h.blog.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class BlogController {
	
	private final PostService postService;
	
	public BlogController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/posts")
	public String getAllPosts() {
		return postService.getAllPosts().toString();
	}
	
	@PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPost(@RequestBody PostDTO postDTO) {
		postService.insert(postDTO);
		return null;
	}
	@GetMapping("/")
	public String init() {
		return "init";
	}
}
