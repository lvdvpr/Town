package com.town.vo;

import java.sql.Timestamp;
import org.apache.ibatis.type.Alias;
import lombok.Getter;

@Alias("Post")
@Getter
public class Post {

	// final 키워드로 필드들을 불변 객체로 만든다.
    private final int postNo;
    private final String title;
    private final String content;
    private final int writerNo;
    private final int readCount;
    private final int suggestionCount;
    private final int commentCount;
    private final int postDeleted;
    private final Timestamp postCreatedDate;
    private final Timestamp postUpdatedDate;
    private final Timestamp postDeletedDate;
    private final int fileAttached;

   // private 생성자 - 외부에서 호출되는 것이 아닌 빌더 클래스에서만 호출되기 때문에 private 접근제한자를 사용한다.
    private Post(PostBuilder builder) {
    	this.postNo = builder.postNo;
    	this.title = builder.title;
    	this.content = builder.content;
    	this.writerNo = builder.writerNo;
    	this.readCount = builder.readCount;
    	this.suggestionCount = builder.suggestionCount;
    	this.commentCount = builder.commentCount;
    	this.postDeleted = builder.postDeleted;
    	this.postCreatedDate = builder.postCreatedDate;
    	this.postUpdatedDate = builder.postUpdatedDate;
    	this.postDeletedDate = builder.postDeletedDate;
    	this.fileAttached = builder.fileAttached;
    }

    // 정적 내부 빌더 클래스
    public static class PostBuilder {
    	private int postNo;
    	private final String title;
    	private final String content;
    	private int writerNo;
    	private int readCount;
    	private int suggestionCount;
    	private int commentCount;
    	private int postDeleted;
    	private Timestamp postCreatedDate;
        private Timestamp postUpdatedDate;
        private Timestamp postDeletedDate;
        private int fileAttached;

        // 필수 파라미터는 빌더 생성자로 받게 한다.
        public PostBuilder(String title, String content) {
        	this.title = title;
        	this.content = content;
        }

        // 선택 파라미터는 각 메서드를 통해 정의한다.
        public PostBuilder postNo(int postNo) {
        	this.postNo = postNo;
        	return this;
        }
        public PostBuilder writerNo(int writerNo) {
        	this.writerNo = writerNo;
        	return this;
        }
        public PostBuilder readCount(int readCount) {
        	this.readCount = readCount;
        	return this;
        }
        public PostBuilder suggestionCount(int suggestionCount) {
        	this.suggestionCount = suggestionCount;
        	return this;
        }
        public PostBuilder commentCount(int commentCount) {
        	this.commentCount = commentCount;
        	return this;
        }
        public PostBuilder postDeleted(int postDeleted) {
        	this.postDeleted = postDeleted;
        	return this;
        }
        public PostBuilder postCreatedDate(Timestamp postCreatedDate) {
        	this.postCreatedDate = postCreatedDate;
        	return this;
        }
        public PostBuilder postUpdatedDate(Timestamp postUpdatedDate) {
        	this.postUpdatedDate = postUpdatedDate;
        	return this;
        }
        public PostBuilder postDeletedDate(Timestamp postDeletedDate) {
        	this.postDeletedDate = postDeletedDate;
        	return this;
        }
        public PostBuilder fileAttached(int fileAttached) {
        	this.fileAttached = fileAttached;
        	return this;
        }
        // 대상 객체의 private 생성자를 호출하여 최종 인스턴스화 한다.
        public Post build() {
        	return new Post(this); // 빌더 객체 자신을 넘긴다.
        }
    }

}
