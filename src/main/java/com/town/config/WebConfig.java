package com.town.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	// 설정 클래스임을 의미
public class WebConfig implements WebMvcConfigurer{	 // 스프링MVC의 설정을 커스터마이징할 수 있도록 해주는 인터페이스
    private String resourcePath = "/update/**"; // view에서 사용할 경로
    private String savePath = "C:/app/town_file/file/";  // 실제 파일이 저장되어 있는 물리 경로 (로컬 디렉토리)

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  // 오버라이딩 메소드
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
