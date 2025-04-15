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

    public void insertPost(int userNo, PostDto postDto, Map<String, String> fileNamesMap) {

        Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), userNo);
        builder.fileAttached(postDto.getFileAttached());
        Post post = builder.build();
        postMapper.insertPost(post);

        if ("Y".equals(postDto.getFileAttached())) {
            // Controller에서 Map자료형에 저장한 저장용 파일이름과 원본파일이름을 가져와서 향상된 for문을 이용해 Postfile객체에 넣는다.
            for (Map.Entry<String, String> entry : fileNamesMap.entrySet()) {
                // PostFile 세팅
                PostFile postfile = new PostFile();
                postfile.setOriginalFileName(entry.getValue());
                postfile.setStoredFileName(entry.getKey());
                postfile.setPostNo(post.getPostNo());  // 위에 postMapper.insertPost(post);을 통해 게시글을 저장해서 auto Increment된 글번호를 가져옴
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