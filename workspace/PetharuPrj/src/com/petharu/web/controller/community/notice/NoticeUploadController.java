package com.petharu.web.controller.community.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/community/notice/upload")
@MultipartConfig (
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*500,
	maxRequestSize = 1024*1024*500*5
)
public class NoticeUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String p = req.getParameter("p");
		Part fpart = req.getPart("file"); //���� �ϳ��� ��.
		String fileName = fpart.getSubmittedFileName(); //������ ���� �̸�
		InputStream fis = fpart.getInputStream(); //���Ͽ� ���� ����, ��Ʈ��
		
		ServletContext application = req.getServletContext();
		
		String path = "/community/notice/upload";
		if (p != null && !p.equals(""))
			path = p;
		
		String realPath = application.getRealPath(path); //Ȩ���丮�� �������� �ϴ� path�� �ָ� �������, �����θ� �˷��ش�.
		
		File pathFile = new File(realPath);
		if (!pathFile.exists()) {
			pathFile.mkdirs(); //��ΰ� ���� ��� dir�� �ϳ���, dirs�� ��� ��θ� ������ش�.
		}
		
		String filePath = realPath + File.separator + fileName; //�ü���� �����ڸ� ����
		FileOutputStream fos =  new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len=fis.read(buf, 0, 1024))>=0)
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();
		
		PrintWriter out = resp.getWriter();
		out.println(path + "/" + fileName);
		
		
	}
	
}
