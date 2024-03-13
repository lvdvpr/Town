package com.town.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.town.service.PostService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String getList() {

        return "list";
    }

    @GetMapping("/form")
    public String getForm() {

        return "post-form";
    }

    @GetMapping("/modify")
    public String getBoardForm() {

        return "boardmodify";
    }
}
