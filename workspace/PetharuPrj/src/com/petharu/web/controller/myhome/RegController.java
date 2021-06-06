package com.petharu.web.controller.myhome;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.JDBCMyhomeService;
import com.petharu.web.service.KnowhowService;
import com.petharu.web.service.MyhomeService;

@WebServlet("/myhome/reg")
@MultipartConfig (
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, // 50메가
	    maxRequestSize = 1024*1024*50*5 // 50메가 파일 5개까지
)
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String content = req.getParameter("content");
		String keyword = req.getParameter("keyword");
		
		Part fpart = req.getPart("f"); 
		String fileName = fpart.getSubmittedFileName(); 
		InputStream fis = fpart.getInputStream(); 
	
		ServletContext application = req.getServletContext(); 
		
		String path = "/upload"; 
		String realPath = application.getRealPath(path); 
		
		File pathFile = new File(realPath); 
		if(!pathFile.exists()) 
			pathFile.mkdirs(); 
		
		String filePath = realPath + File.separator + fileName; 
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buf, 0, 1024)) >= 0) 
			fos.write(buf, 0, len); 
		
		fos.flush();
		fos.close();
		fis.close();

		MyhomeService myhomeService = new JDBCMyhomeService();
		
		try {
			
			Diary diary = new Diary();
			diary.setMemberId(1); // 수정 필요
			diary.setKeyword(keyword);
			diary.setContent(content);
			diary.setImage(fileName);
			myhomeService.insert(diary);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		resp.sendRedirect("list.html");
	};
	
}
