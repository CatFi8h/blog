package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.PostDTO;
import com.catfi8h.blog.entities.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimplePostMapperTest {
	
	private SimplePostMapper mapper;
	
	@BeforeEach
	public void setUp() {
		mapper = Mappers.getMapper(SimplePostMapper.class);
	}
	
	@Test
	public void toSimplePost() {
		PostDTO postDTO = new PostDTO("title", "body");
		
		Post post = mapper.postToPostDTO(postDTO);
		assertNotNull(post);
		assertEquals("title", post.getTitle());
		assertEquals("body", post.getBody());
	}
	
	
	
}