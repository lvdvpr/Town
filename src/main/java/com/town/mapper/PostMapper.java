package com.town.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.town.dto.PostDto;
import com.town.dto.PostListDto;
import com.town.vo.Post;
import com.town.vo.PostFile;

@Mapper
public interface PostMapper {

	void insertPost(Post post);
	void insertFile(PostFile postfile);
	List<PostListDto> getPostList();
	PostDto getPostDtoByPostNo(int postNo);
	void updateReadCount(int postNo);
	void deletePostByPostNo(int postNo);
	List<PostFile> getPostFile(int postNo);
}
