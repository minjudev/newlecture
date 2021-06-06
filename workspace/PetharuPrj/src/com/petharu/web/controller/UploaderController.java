package com.petharu.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploader")
@MultipartConfig (
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*500, 
    maxRequestSize = 1024*1024*500*5 
)
public class UploaderController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Part fpart = request.getPart("f"); 
		String fileName = fpart.getSubmittedFileName(); 
		InputStream fis = fpart.getInputStream(); 
	
		ServletContext application = request.getServletContext(); 
		
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
		
		PrintWriter out = response.getWriter();
		out.println(path + "/" + fileName); 

	}	
}
