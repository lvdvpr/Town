package com.town.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.town.vo.Post;
import com.town.vo.PostFile;

@Mapper
public interface PostMapper {

	void insertPost(Post post);
	void insertFile(PostFile postfile);

}
