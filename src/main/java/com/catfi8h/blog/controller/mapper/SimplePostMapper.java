package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.AccountDto;
import com.catfi8h.blog.controller.dto.GetPostDto;
import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.repository.entities.Account;
import com.catfi8h.blog.repository.entities.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SimplePostMapper {

	private final SimpleAccountMapper simpleAccountMapper;
	
	public Post insertDtoToPost(InsertPostDto dto){
		Post post = new Post();
		post.setBody(dto.getBody());
		post.setTitle(dto.getTitle());
		AccountDto accountDto = dto.getAccount();
		Account account = simpleAccountMapper.dtoToAccount(accountDto);
		post.setAccount(account);
		return post;
	}
	
	public InsertPostDto insertPostToDto(Post post){
		InsertPostDto postDTO = new InsertPostDto();
		postDTO.setBody(post.getBody());
		postDTO.setTitle(post.getTitle());
		return postDTO;
	}
	
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
