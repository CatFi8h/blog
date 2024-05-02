package com.catfi8h.blog.controller;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PriorityQueue;

@RestController("/my")
public class BlogController {

	private final PostService postService;

	public BlogController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public List<GetPostDto> getAllPosts() {
//		PriorityQueue<Integer> integers = new PriorityQueue<>();
		return postService.getAllPosts();
	}

	@PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPost(@RequestBody InsertPostDto dto) {
		postService.insert(dto);
		return "Created";
	}
}
