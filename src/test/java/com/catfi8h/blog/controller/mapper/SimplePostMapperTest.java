package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.InsertPostDto;
import com.catfi8h.blog.repository.entities.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimplePostMapperTest {
	
	private SimplePostMapper mapper;
	
	@BeforeEach
	public void setUp() {
		mapper = new SimplePostMapper();
	}
	
	@Test
	public void toSimplePost() {
		InsertPostDto postDTO = new InsertPostDto("title", "body");
		
		Post post = mapper.insertDtoToPost(postDTO);
		assertNotNull(post);
		assertEquals("title", post.getTitle());
		assertEquals("body", post.getBody());
	}
	
	
	
}