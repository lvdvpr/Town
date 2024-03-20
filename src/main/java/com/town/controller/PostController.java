package com.town.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.town.dto.PostDto;
import com.town.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String getList() {

        return "post-list";
    }

    @GetMapping("/form")
    public String getForm() {

        return "post-form";
    }

    @PostMapping("/form")
    public String insertPost(PostDto postDto) throws IOException {
    	postService.insertPost(postDto);
    	return "redirect:list";
    }

}
