package com.town.service;

import org.springframework.stereotype.Service;

import com.town.mapper.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

}