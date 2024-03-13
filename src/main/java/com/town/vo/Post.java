package com.town.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Post {

    private int postNo;
    private String title;
    private String content;
    private int writerNo;
    private int readCount;
    private int suggestionCount;
    private int commentCount;
    private int postDeleted;
    private Timestamp postCreatedDate;
    private Timestamp postUpdatedDate;
    private Timestamp postDeletedDate;

}
