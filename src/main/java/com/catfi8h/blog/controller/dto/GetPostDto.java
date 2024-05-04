package com.catfi8h.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPostDto {
	private Long id;
	private String title;
	private String body;
	private String author;
	private Date createTime;
}
