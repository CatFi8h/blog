package com.catfi8h.blog.service;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.controller.mapper.SimplePostMapper;
import com.catfi8h.blog.repository.AccountRepository;
import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.entities.Post;
import com.catfi8h.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostRepository postRepository;
	private final SimplePostMapper postMapper;
	private final AccountRepository accountRepository;
	
	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}
	
	public List<GetPostDto> getAllPosts() {
		return postRepository.findAll().stream().map(postMapper::getPostToDto).toList();
	}
	
	public Long insert(InsertPostDto dto) {
		
		Optional<Account> oneByEmail = accountRepository.findOneByEmail(dto.getEmail());
		if (oneByEmail.isPresent()) {
			Post post = new Post();
			post.setBody(dto.getBody());
			post.setTitle(dto.getTitle());
			post.setCreationDate(Date.from(Instant.now()));
			post.setAccount(oneByEmail.get());
			return postRepository.save(post).getId();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
