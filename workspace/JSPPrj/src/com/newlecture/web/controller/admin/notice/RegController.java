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
    maxFileSize = 1024*1024*50, // 50메가
    maxRequestSize = 1024*1024*50*5 // 50메가 파일 5개까지
)

public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		// 아래 코드가 페이지마다 있어야 인증 확인이 가능함
		// 현재 사용자가 login 프로세스를 통해 인증되지 않았다면 인증을 하고 오라는 메시지 출력
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("uid"); // 반환 타입: 오브젝트
		if(uid == null) {
			response.sendRedirect("../../member/login?returnURL=/admin/notice/reg");
			// 로그인하고 올때는 다시 이 주소로 오라는 것 명시
			return;
		}*/
		
		//request.setAttribute("uid", uid);
		request.getRequestDispatcher("/WEB-INF/view/admin/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 동일한 name 속성에 대한 값을 배열로 받을 수 있음
		/*
		String[] hobbys = request.getParameterValues("h");
		System.out.println(hobbys[0] + hobbys[1]); // 체크박스 둘 다 선택해야 오류 발생X
		*/
		
		String fileNames = "";
		int fileCount = 0;
		
		Collection<Part> parts = request.getParts();
		for(Part fpart : parts) {
			if(!fpart.getName().equals("f"))
				continue; // name 값이 f가 아니면 다음 반복으로 건너뜀
				// break; 반복문을 벗어남
			
			if(fpart.getSize() == 0) // 파일을 하나만 업로드했을 경우 정상 업로드되게 하기
				continue;
				
			System.out.printf("name: %s\n", fpart.getName());

			// 입력 스트림에서 파일을 읽고 출력 스트림에서 파일 출력
			// Part fpart = request.getPart("f"); // 파일을 가져오기, 반환 타입이 파트형
			String fileName = fpart.getSubmittedFileName(); // 전송된 파일 이름
			InputStream fis = fpart.getInputStream(); // 파일 스트림
			
			fileNames += fileName + ",";
			fileCount++;
			
			ServletContext application = request.getServletContext(); // 어플리케이션의 저장소 역할, 다른 서블릿이 작업을 이어가려면 동일한 도구, 저장소(ServletContext)가 필요
			String path = "/upload"; // 업로드할 경로, 해당 경로는 절대 경로로 설정해야 파일 출력 나옴, 하지만 배포 서버가 모두 다를 것이므로 정적으로 설정하면 안됨
			String realPath = application.getRealPath(path); // 실제 물리 경로를 얻어내줌
			
			File pathFile = new File(realPath); // 파일 만들기
			if(!pathFile.exists()) // 파일이 없으면
				pathFile.mkdirs(); // 경로를 만들어줌
			
			String filePath = realPath + File.separator + fileName; // 운영체제마다 파일 구분자가 다를 수 있음
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
		
		if(fileCount > 0) // 파일 개수가 1개 이상일 때만 아래 코드 실행
			fileNames = fileNames.substring(0, fileNames.length()-1); // 끝에 쉼표 없애기
		
		NoticeService service = new JdbcNoticeService();
		
		// service.update(id, title, content);
		
		try {
			
			Notice notice = new Notice();
			notice.setTitle(title); // update할 내용만 set 메서드로 바꾸기
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
