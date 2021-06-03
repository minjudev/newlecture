package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("adminHomeController")
@RequestMapping("/admin/")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		return "admin index page";
	}

	@PostMapping("upload") // 비동기적으로 파일 업로드하기
	public String upload(MultipartFile[] files, /*file이라는 같은 변수명으로 받으려면 name 속성도 같은 이름("file")이어야함, name 속성 이름이 다르다면 RequestParam을 써줘야함*/
			HttpServletRequest request) {
		
		for(MultipartFile file : files) {
			
			if(file.getSize() == 0) // 파일이 없을 때는 반복문 넘어가기
				continue;
			
			String fileName = file.getOriginalFilename(); // file 이름 얻기
			
			ServletContext application = request.getServletContext();
			String path = "/upload"; 
			String realPath = application.getRealPath(path);
			
			File pathFile = new File(realPath);
			if(!pathFile.exists())
				pathFile.mkdirs();
			
			String filePath = realPath + File.separator + fileName;
			
			File saveFile = new File(filePath); // 저장할 파일, 파일에 대한 정보 구조가 메모리에 생기기만 하는 것
			
			try {
				file.transferTo(saveFile); // 이 메소드에 의해 저장 경로에 실질적으로 파일이 생성됨, 저장하려고 한 파일이 저장되는 것임
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return "ok";
	}
}
