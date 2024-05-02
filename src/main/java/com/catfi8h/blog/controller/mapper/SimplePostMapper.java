package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.repository.entities.Post;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class SimplePostMapper {
	public Post insertDtoToPost(InsertPostDto dto){
		Post post = new Post();
		post.setBody(dto.getBody());
		post.setTitle(dto.getTitle());
		return post;
	}
	
	public InsertPostDto insertPostToDto(Post post){
		InsertPostDto postDTO = new InsertPostDto();
		postDTO.setBody(post.getBody());
		postDTO.setTitle(post.getTitle());
		return postDTO;
	}
	
	public GetPostDto getPostToDto(Post post){
		GetPostDto postDTO = new GetPostDto(post.getId(),post.getTitle(), post.getBody(), post.getCreationDate());
		postDTO.setBody(post.getBody());
		postDTO.setTitle(post.getTitle());
		return postDTO;
	}
}
