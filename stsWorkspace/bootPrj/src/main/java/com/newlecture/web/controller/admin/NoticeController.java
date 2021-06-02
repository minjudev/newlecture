package com.newlecture.web.controller.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminNoticeController")
@RequestMapping("/admin/notice/") // url이 기니까 줄이자!
public class NoticeController {

	@RequestMapping("list") 
	public String list() {
		return "admin notice list";
	}
	
	// @RequestMapping(value = "reg", method = RequestMethod.GET) 
	@GetMapping("reg") // get, post 요청 둘 다 필요
	public String reg(
			@RequestParam(name = "f") String field, // parameter로 f가 왔을 때 field라는 변수로 이름 변경
			@RequestParam(defaultValue = "0") Integer x, // null, 빈 공백이 오면 기본값은 0, String을 Integer로 바꿔줌
			@RequestParam(defaultValue = "0") Integer y, 
			@CookieValue(name = "test", defaultValue = "hi") String test, // 쿠키가 없을 때 기본값: hi, 쿠키 변수 이름은 test 
			HttpServletResponse response
			) { 
		
		if(test.equals("hi")) { // 쿠키가 없을 때는 쿠키를 담기
			Cookie cookie = new Cookie("test", "hello"); // 키: test
			cookie.setMaxAge(10*24*60*60); // expire되는 시간, 브라우저가 닫쳐도 10일 동안 쿠키가 유지됨
			cookie.setPath("/"); // 루트 아래 모든 경로에서 쿠키가 유지됨
			// 현재 path 이하에서만 쿠키를 볼 수 있도록 설정됨
			// admin/notice/* (o)
			// admin/notice/aa/bb/list (o)
			
			response.addCookie(cookie); // 처음 요청 시에는 쿠키가 없지만 응답에는 Set-Cookie에 키가 심어져서 옴
			                            // 다음에 페이지 재요청시 요청 헤더의 Cookie에 키값(test=hello)이 같이 감 			
		}
		
		// 1. Servlet API를 이용한 방법(HttpServlet)
		// String x_ = request.getParameter("x");
		// String y_ = request.getParameter("y");
		
		// 2. 파라미터 이름으로 자동 입력(매개변수에서만 파라미터 이름 넘겨주기)
		// null, 빈 공백에 대한 기본값 설정, 문자를 숫자로 변환하는 작업
		// @RequestParam(defaultValue = "0") Integer x
		
		
		// return String.format("x_: %s, y_: %s", x_, y_) + "<br>" 
		return String.format("x: %d, y: %d, result: %d, field: %s, test cookie: %s\n", x, y, x+y, field, test);
	}
	
	@PostMapping("reg")
	public String reg(String test) { // get, post 요청 둘 다 필요
		
		return "admin notice reg";
	}
	
	@RequestMapping("edit") // get, post 요청 둘 다 필요
	public String edit() {
		return "admin notice edit";
	}
	
	@RequestMapping("del") 
	public String del() {
		return "admin notice del";
	}
}
