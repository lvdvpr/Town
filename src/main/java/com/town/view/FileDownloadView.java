package com.town.view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // 자동으로 스프링 빈으로 등록
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		File file = (File) model.get("file");
		// application/octet-stream - 일반적인 바이너리 데이터에 대한 컨텐츠 타입이다.
		setContentType("application/octet-stream");
		// 응답메세지의 헤더부에 특정 정보를 담은 헤더를 설정하는 부분
		// Content-Disposition : 서버가 보내는 내용(콘텐츠)을 어떻게 처리해야 할지 알려주는 역할. attachment; 는 브라우저에서 파일을 열지 않고, 항상 다운로드되게 한다.
		// URLEncoder.encode(text,encoding)은 텍스트를 지정된 인코딩 방식으로 변환시킨다.
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), "utf-8"));
		// new FileInputStream(file) : 파일을 읽어오는 입력스트림 객체를 생성한다.
		// response.getOutputStream() : 브라우저와 연결된 출력스트림을 획득한다.
		// 입력스트림으로 읽은 데이터를 출력스트림으로 복사해서 출력시킨다.
		FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());

	}
}
