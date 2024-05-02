package com.catfi8h.blog.controller.thymeleaf;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogController {
	
	private final PostService postService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<GetPostDto> allPosts = postService.getAllPosts();
		model.addAttribute("posts", allPosts);
		return "home";
	}

}
