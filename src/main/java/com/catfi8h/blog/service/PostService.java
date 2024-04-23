package com.catfi8h.blog.service;

import com.catfi8h.blog.controller.dto.PostDTO;
import com.catfi8h.blog.controller.mapper.SimplePostMapper;
import com.catfi8h.blog.entities.Post;
import com.catfi8h.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
	public final PostRepository postRepository;
	public final SimplePostMapper postMapper;
	
	
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	public void insert(PostDTO postDTO) {
		System.out.println(postDTO.getBody() + " " +  postDTO.getTitle());
		Post post = postMapper.postToPostDTO(postDTO);
		System.out.println(post.getBody() + " " +  post.getTitle());
		postRepository.save(post);
	}
}
