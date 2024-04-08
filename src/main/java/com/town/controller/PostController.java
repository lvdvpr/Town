package com.town.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.town.dto.PostDto;
import com.town.dto.PostListDto;
import com.town.security.LoginUser;
import com.town.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

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
    	postService.insertPost(loginUser.getUserNo(), postDto);
    	return "redirect:list";
    }

}
