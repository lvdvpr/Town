package com.town.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Alias("PostListDto")
@Getter
@Setter
@ToString
public class PostListDto {

	private int postNo;
	private String title;
	private String userName;
	private String fileAttached;		  // 파일이 담겨있는지 여부를 나타내는 필드
	private int readCount;
	private int suggestionCount;
	private int commentCount;
	private Timestamp postCreatedDate;

	public PostListDto() {}

	public PostListDto(int postNo, String title, String userName, String fileAttached, int writeNo, int readCount, int suggestionCount,
			int commentCount, Timestamp postCreatedDate) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.userName = userName;
		this.fileAttached = fileAttached;
		this.readCount = readCount;
		this.suggestionCount = suggestionCount;
		this.commentCount = commentCount;
		this.postCreatedDate = postCreatedDate;
	}


}
