package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.repository.entities.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SimplePostMapper {

	public GetPostDto getPostToDto(Post post){
		GetPostDto postDTO = new GetPostDto(post.getId(),
				post.getTitle(),
				post.getBody(),
				post.getAccount().getFirstName(),
				post.getCreationDate());
		postDTO.setBody(post.getBody());
		postDTO.setTitle(post.getTitle());
		return postDTO;
	}
}
