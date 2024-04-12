package com.town.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.town.dto.PostDto;
import com.town.dto.PostListDto;
import com.town.mapper.PostMapper;
import com.town.vo.Post;
import com.town.vo.PostFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public List<PostListDto> getPostList() {

    	return postMapper.getPostList();
    }

    public void insertPost (int userNo, Post post) {
    	postMapper.insertPost(post);
    }

    public void insertFile (PostFile postfile) throws IOException {
	    	postMapper.insertFile(postfile);
    }

	public void updateReadCount(int postNo) {
		postMapper.updateReadCount(postNo);
	}

	public PostDto getPostDtoByPostNo(int postNo) {
		return postMapper.getPostDtoByPostNo(postNo);
	}

	public void deletePostByPostNo(int postNo) {
		postMapper.deletePostByPostNo(postNo);
	}

	public List<PostFile> getPostFile(int postNo) {
		return postMapper.getPostFile(postNo);
	}

}