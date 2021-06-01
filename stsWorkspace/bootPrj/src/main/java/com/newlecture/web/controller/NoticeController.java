package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	@RequestMapping("/notice/list")
	public String list() {
		return "notice list";
	}
}
