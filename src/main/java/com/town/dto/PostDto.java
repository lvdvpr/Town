package com.town.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("PostDto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {

	private int postNo;
	private String title;
	private String content;
	private int writerNo;
	private String name;
	private int readCount;
	private int suggestionCount;
	private int commentCount;
	private int fileAttached;		  // 파일이 담겨있는지 여부를 나타내는 필드
	private List<MultipartFile> files; // 게시글을 작성할 때 파일 자체를 담기 위한 필드
	private Timestamp postCreatedDate;
	private String postDeleted;


}
