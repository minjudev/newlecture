package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@RequestMapping("/index")
	public String index() {
		return "index"; // RestController에서 rest를 지우면 포워딩을, rest를 쓰면 바로 출력하는 것을 의미
	}
	
	// 기능을 담당하는 것을 class로 만들고 그 앞의 경로는 package로 만들기!
	// com.newlecture.web.controller.admin.NoticeController.list()
	/*
	@RequestMapping("/admin/notice/list")
	public String list() {
		return "list";
	}*/
	
	
	// com.newlecture.web.controller.NoticeController.list()
	/*
	@RequestMapping("/notice/list")
	public String list() {
		return "list";
	}*/
	
	
}
