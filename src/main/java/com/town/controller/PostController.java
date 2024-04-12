package com.town.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.town.dto.PostDto;
import com.town.dto.PostListDto;
import com.town.exception.ApplicationException;
import com.town.security.LoginUser;
import com.town.service.PostService;
import com.town.view.FileDownloadView;
import com.town.vo.Post;
import com.town.vo.PostFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

	private final String savePath = "C:/app/town_file/file/";

    private final PostService postService;
	private final FileDownloadView fileDownloadView;

    @GetMapping("/list")
    public String getPostList(Model model) {
    	List<PostListDto> postDtoList = postService.getPostList();
    	model.addAttribute("postDtoList", postDtoList);
        return "post-list";
    }

    @GetMapping("/form")
    public String getPostForm() {

        return "post-form";
    }

    @PostMapping("/form")
    public String insertPost(@AuthenticationPrincipal LoginUser loginUser, PostDto postDto) throws IOException {
    	//첨부파일 업로드 처리
    	List<MultipartFile> files = postDto.getFiles();
    	if (!files.get(0).isEmpty()) {
    		// 파일 있음
    		postDto.setFileAttached(1);
    		Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), loginUser.getUserNo());
    		builder.fileAttached(postDto.getFileAttached());
    		Post post = builder.build();
    		postService.insertPost(loginUser.getUserNo(), post);
    		for(MultipartFile file : postDto.getFiles()) {
    			PostFile postfile = new PostFile();
	    		// 파일 이름 가져오기
	    		String originalFilename = file.getOriginalFilename();
	    		// 저장용 이름 만들기
	    		String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
	    		// PostFile 세팅
	    		postfile.setOriginalFileName(originalFilename);
	    		postfile.setStoredFileName(storedFileName);
	    		postfile.setPostNo(post.getPostNo());
	    		// 파일 저장용 폴더에 파일 저장 처리
	    		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(savePath, originalFilename)));
	    		postService.insertFile(postfile);
    		}
    	} else if (postDto.getFiles().get(0).isEmpty()) {
    		// 파일 없음
    		postDto.setFileAttached(0);

    		Post.PostBuilder builder = new Post.PostBuilder(postDto.getTitle(), postDto.getContent(), loginUser.getUserNo());
    		builder.fileAttached(postDto.getFileAttached());

    		Post post = builder.build();
    		postService.insertPost(loginUser.getUserNo(), post);
    	}

    		return "redirect:list";
    }

    @GetMapping("/download")
    public ModelAndView fileDownload(@RequestParam("originalFileName") String originalFileName) {
    	File file = new File(savePath, originalFileName);
    	if (!file.exists()) {
    		throw new ApplicationException("["+originalFileName+"] 파일이 존재하지 않습니다.");
    	}

    	ModelAndView mav = new ModelAndView();
    	mav.addObject("file", file);
    	mav.setView(fileDownloadView);

    	return mav;
    }

    @GetMapping("/{postNo}")
    public String getPostDtoByPostNo(@PathVariable int postNo, Model model) {
    	/*
    	 *  해당 게시글의 조회수를 하나 올리고
    	 *  게시글 데이터를 가져와서 post-detail.jsp에 출력
    	 */
    	postService.updateReadCount(postNo);
    	PostDto postDto = postService.getPostDtoByPostNo(postNo);
    	model.addAttribute("postDto", postDto);
    	if (postDto.getFileAttached() == 1) {
    		List<PostFile> postfile = postService.getPostFile(postNo);
    		model.addAttribute("postFile", postfile);
    	}

    	return "post-detail";
    }


    @GetMapping("/delete")
    public String deletePostByPostNo(@RequestParam int postNo) {
    	postService.deletePostByPostNo(postNo);
    	return "redirect:list";
    }

}
