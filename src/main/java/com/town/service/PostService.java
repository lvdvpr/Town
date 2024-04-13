package com.town.service;

import java.util.List;
import java.util.Map;

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

    public void insertPost (int userNo, PostDto postDto, Map<String, String> fileNamesMap) {

		Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), userNo);
		builder.fileAttached(postDto.getFileAttached());
		Post post = builder.build();
		postMapper.insertPost(post);

		if ("Y".equals(postDto.getFileAttached())) {
			for(Map.Entry<String, String> entry : fileNamesMap.entrySet()) {
	    		// PostFile 세팅
				PostFile postfile = new PostFile();
	    		postfile.setOriginalFileName(entry.getValue());
	    		postfile.setStoredFileName(entry.getKey());
	    		postfile.setPostNo(post.getPostNo());
	    		postMapper.insertFile(postfile);
			}
		}
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