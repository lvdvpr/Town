package com.town.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostDto {

	private int postNo;
	private String title;
	private String content;
	private int fileAttached;		// 파일이 담겨있는지 여부를 나타내는 필드
	private List<MultipartFile> file; // 게시글을 작성할 때 파일 자체를 담기 위한 필드
}
