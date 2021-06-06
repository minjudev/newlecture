package com.petharu.web.controller.community.knowhow;

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

import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.KnowhowService;

@WebServlet("/community/knowhow/reg")
@MultipartConfig (
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*50, // 50�ް�
    maxRequestSize = 1024*1024*50*5 // 50�ް� ���� 5������
)
public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/community/knowhow/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pet = req.getParameter("pet");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// ���� ���ε��ϱ�
		Part fpart = req.getPart("f"); // ������ ��������, ��ȯ Ÿ���� ��Ʈ��
		String fileName = fpart.getSubmittedFileName(); // ���۵� ���� �̸�
		InputStream fis = fpart.getInputStream(); // ���� ��Ʈ��
		
		ServletContext application = req.getServletContext(); // ���ø����̼��� ����� ����, �ٸ� ������ �۾��� �̾���� ������ ����, �����(ServletContext)�� �ʿ�
		String path = "/upload"; // ���ε��� ���, �ش� ��δ� ���� ��η� �����ؾ� ���� ��� ����, ������ ���� ������ ��� �ٸ� ���̹Ƿ� �������� �����ϸ� �ȵ�
		String realPath = application.getRealPath(path); // ���� ���� ��θ� ����
		
		File pathFile = new File(realPath); // ���� �����
		if(!pathFile.exists()) // ������ ������
			pathFile.mkdirs(); // ��θ� �������
		
		String path_ = path + File.separator + fileName;
		String filePath = realPath + File.separator + fileName; // �ü������ ���� �����ڰ� �ٸ� �� ����
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buf, 0, 1024)) >= 0)
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();

		KnowhowService knowhowService = new JDBCKnowhowService();
		
		try {
			
			Knowhow knowhow = new Knowhow();
			knowhow.setMemberId(1); // ���� �ʿ�
			knowhow.setKnowhowTypeName(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhowService.insert(knowhow);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		req.setAttribute("path", path_);
		resp.sendRedirect("list");
	};
	
}
