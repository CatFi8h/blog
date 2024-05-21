package com.catfi8h.blog.controller.thymeleaf;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.controller.mapper.SimplePostMapper;
import com.catfi8h.blog.repository.entities.Post;
import com.catfi8h.blog.service.AccountService;
import com.catfi8h.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class PostController {
	
	private final PostService postService;
	private final SimplePostMapper simplePostMapper;
	private final AccountService accountService;
	
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
	
	@GetMapping("/post/new")
	public String createNewPost(Model model) {
		Optional<AccountDto> accountOpt = accountService.findDtoByEmail("user.user@domain.com");
		if (accountOpt.isPresent()) {
			InsertPostDto insertPostDto = new InsertPostDto();
			insertPostDto.setEmail(accountOpt.get().getEmail());
			model.addAttribute("post", insertPostDto);
			return "post_new";
		} else {
			return "redirect:/error";
		}
	}
	
	
	@PostMapping("/post/new")
	public String saveNewPost(@ModelAttribute InsertPostDto post, Model model) {
		Long id = postService.insert(post);
		return "redirect:/post/" + id;
	}
}
