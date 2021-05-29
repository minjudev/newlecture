package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/notice/reg") 
@MultipartConfig (
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*50, // 50�ް�
    maxRequestSize = 1024*1024*50*5 // 50�ް� ���� 5������
)

public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		// �Ʒ� �ڵ尡 ���������� �־�� ���� Ȯ���� ������
		// ���� ����ڰ� login ���μ����� ���� �������� �ʾҴٸ� ������ �ϰ� ����� �޽��� ���
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("uid"); // ��ȯ Ÿ��: ������Ʈ
		if(uid == null) {
			response.sendRedirect("../../member/login?returnURL=/admin/notice/reg");
			// �α����ϰ� �ö��� �ٽ� �� �ּҷ� ����� �� ���
			return;
		}*/
		
		//request.setAttribute("uid", uid);
		request.getRequestDispatcher("/WEB-INF/view/admin/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// ������ name �Ӽ��� ���� ���� �迭�� ���� �� ����
		/*
		String[] hobbys = request.getParameterValues("h");
		System.out.println(hobbys[0] + hobbys[1]); // üũ�ڽ� �� �� �����ؾ� ���� �߻�X
		*/
		
		String fileNames = "";
		int fileCount = 0;
		
		Collection<Part> parts = request.getParts();
		for(Part fpart : parts) {
			if(!fpart.getName().equals("f"))
				continue; // name ���� f�� �ƴϸ� ���� �ݺ����� �ǳʶ�
				// break; �ݺ����� ���
			
			if(fpart.getSize() == 0) // ������ �ϳ��� ���ε����� ��� ���� ���ε�ǰ� �ϱ�
				continue;
				
			System.out.printf("name: %s\n", fpart.getName());

			// �Է� ��Ʈ������ ������ �а� ��� ��Ʈ������ ���� ���
			// Part fpart = request.getPart("f"); // ������ ��������, ��ȯ Ÿ���� ��Ʈ��
			String fileName = fpart.getSubmittedFileName(); // ���۵� ���� �̸�
			InputStream fis = fpart.getInputStream(); // ���� ��Ʈ��
			
			fileNames += fileName + ",";
			fileCount++;
			
			ServletContext application = request.getServletContext(); // ���ø����̼��� ����� ����, �ٸ� ������ �۾��� �̾���� ������ ����, �����(ServletContext)�� �ʿ�
			String path = "/upload"; // ���ε��� ���, �ش� ��δ� ���� ��η� �����ؾ� ���� ��� ����, ������ ���� ������ ��� �ٸ� ���̹Ƿ� �������� �����ϸ� �ȵ�
			String realPath = application.getRealPath(path); // ���� ���� ��θ� ����
			
			File pathFile = new File(realPath); // ���� �����
			if(!pathFile.exists()) // ������ ������
				pathFile.mkdirs(); // ��θ� �������
			
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
		}
		
		if(fileCount > 0) // ���� ������ 1�� �̻��� ���� �Ʒ� �ڵ� ����
			fileNames = fileNames.substring(0, fileNames.length()-1); // ���� ��ǥ ���ֱ�
		
		NoticeService service = new JdbcNoticeService();
		
		// service.update(id, title, content);
		
		try {
			
			Notice notice = new Notice();
			notice.setTitle(title); // update�� ���븸 set �޼���� �ٲٱ�
			notice.setWriterId("minju");
			notice.setContent(content);
			notice.setFiles(fileNames);
			service.insert(notice);
			// service.insert(title, content);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list");
		
	}
}
