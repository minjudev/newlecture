package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice/")
public class NoticeController {
	
	@RequestMapping("list")
	public String list() {
		return "notice list";
	}
	
	@RequestMapping("detail") // 알아서 서버 재시작을 해줬으면 좋겠다!
	public String detail() {
		return "notice detail";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "notice reg";
	}
	
	@RequestMapping("edit")
	public String edit() {
		return "notice edit";
	}
}
