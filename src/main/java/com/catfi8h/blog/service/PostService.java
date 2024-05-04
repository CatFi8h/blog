package com.catfi8h.blog.service;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.controller.mapper.SimplePostMapper;
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
	public final PostRepository postRepository;
	public final SimplePostMapper postMapper;
	
	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}
	
	public List<GetPostDto> getAllPosts() {
		return postRepository.findAll().stream().map(postMapper::getPostToDto).toList();
	}
	
	public void insert(InsertPostDto postDTO) {
//		System.out.println(postDTO.getBody() + ' ' +  postDTO.getTitle());
		Post post = postMapper.insertDtoToPost(postDTO);
//		System.out.println(post.getBody() + ' ' +  post.getTitle());
		post.setCreationDate(Date.from(Instant.now()));
		postRepository.save(post);
	}
}
