package com.town.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("PostFile")
@Data
public class PostFile {
	private int fileNo;
	private int postNo;
	private String originalFileName;	// 사용자가 올린 원본파일 이름
	private String storedFileName;		// 저장을 위한 파일 이름 (사용자가 올린 원본파일 이름이 중복될 수 있으므로)
	private Timestamp fileCreatedDate;
	private Timestamp fileDeletedDate;
	private String fileDeleted;
}
