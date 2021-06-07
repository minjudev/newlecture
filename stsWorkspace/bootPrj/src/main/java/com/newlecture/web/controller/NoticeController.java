package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Notice> list = service.getList();
		model.addAttribute("list", list);
		
		return "notice.list";
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
