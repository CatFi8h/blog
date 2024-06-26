package com.catfi8h.blog.controller.thymeleaf;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.mapper.SimplePostMapper;
import com.catfi8h.blog.repository.entities.Post;
import com.catfi8h.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class PostController {
	
	private final PostService postService;
	private final SimplePostMapper simplePostMapper;
	
	@GetMapping("/post/{id}")
	public String post(@PathVariable Long id, Model model) {
		Optional<Post> postById = postService.getPostById(id);
		if (postById.isPresent()) {
			Post post = postById.get();
			GetPostDto postToDto = simplePostMapper.getPostToDto(post);
			model.addAttribute("post", postToDto);
			return "post";
		} else {
			return "redirect:/error";
		}
	}
}
