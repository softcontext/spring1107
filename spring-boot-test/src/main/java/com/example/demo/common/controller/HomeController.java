package com.example.demo.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 뷰를 따로 두고 화면을 그린(JSP) 다음 화면 결과(HTML)를 클라이언트에게 전달할 때 사용한다.
@Controller
public class HomeController {
	
	// http://localhost:9090/example/
	@RequestMapping("/")
	public String home() {
		// /WEB-INF/views/welcome.jsp 위치에 있는
		// JSP로 포워딩한다.
		return "welcome";
	}
	
}
