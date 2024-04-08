package com.town.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public void insertPost(int userNo, PostDto postDto) throws IOException {
    	if (postDto.getFile().get(0).isEmpty()) {
    		// 파일 없음
    		postDto.setFileAttached(0);

    		Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), userNo);
    		builder.fileAttached(postDto.getFileAttached());

    		Post post = builder.build();

    		postMapper.insertPost(post);
    	} else {
    		// 파일 있음
    		postDto.setFileAttached(1);
    		Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), userNo);
    		builder.fileAttached(postDto.getFileAttached());

    		Post post = builder.build();
    		// 게시글 저장 후 postNo값 활용을 위해 insert문에 useGeneratedKeys와 keyProperty 사용
    		postMapper.insertPost(post);
    		// 파일만 따로 가져오기
    		for (MultipartFile file : postDto.getFile()) {
	    		// 파일 이름 가져오기
	    		String originalFilename = file.getOriginalFilename();
	    		// 저장용 이름 만들기
	    		String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
	    		// PostFile 세팅
	    		PostFile postfile = new PostFile();
	    		postfile.setOriginalFileName(originalFilename);
	    		postfile.setStoredFileName(storedFileName);
	    		postfile.setPostNo(post.getPostNo());
	    		// 파일 저장용 폴더에 파일 저장 처리
	    		String savePath = "C:/app/town_file/file/" + storedFileName;
	    		file.transferTo(new File(savePath));
	    		// db에 저장
	    		postMapper.insertFile(postfile);
    		}
    	}
    }

}