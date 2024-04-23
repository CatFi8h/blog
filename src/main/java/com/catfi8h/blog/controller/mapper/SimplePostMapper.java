package com.catfi8h.blog.controller.mapper;

import com.catfi8h.blog.controller.dto.PostDTO;
import com.catfi8h.blog.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SimplePostMapper {
	Post postToPostDTO(PostDTO dto);
	PostDTO postDtoToPost(Post post);
}
