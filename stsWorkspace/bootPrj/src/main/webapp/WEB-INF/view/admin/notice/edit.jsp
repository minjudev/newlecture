<%@page import="com.newlecture.web.service.JdbcNoticeService"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="com.newlecture.web.entity.Member"%>
<%@page import="com.newlecture.web.service.MemberService"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id_ = request.getParameter("id"); 
	int id = Integer.parseInt(id_); 

	NoticeService noticeService = new JdbcNoticeService();
	Notice notice = noticeService.get(id); 
 	System.out.println(notice);
 %>

<main id="main">
	<section>
		<h1 class="main-title">공지사항</h1>
		<section class="breadcrumb">
			<h1 class="d-none">경로</h1>
			<ol>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ol>
		</section>

		<form action="edit" method="post">
			<!-- 서블릿을 처리기로 해서 사용자가 수정한 내용을 저장하도록 서버에 post로 보내고, 서버가 redirect해서 수정 내용이 반영된 detail.jsp 보여주게 하기 -->
			<table border="1">
				<tr>
					<th>제목</th>
					<!-- 컬럼 내에서의 제목: th -->
					<td colspan="3"><input type="text" name="title"
						value="<%=notice.getTitle() %>"></td>
					<!-- DB에 해당되는 내용 나오게 하기 -->
				</tr>
				<tr>
					<th>작성일</th>
					<td colspan="3"><%=notice.getRegDate() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=notice.getWriterId() %></td>
					<th>조회수</th>
					<td><%=notice.getHit() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><%=notice.getFiles() %></td>
				</tr>
				<tr>
					<td colspan="4"><textarea rows="20" cols="80" name="content">
	                        			<%=notice.getContent() %>
	                        		</textarea></td>
				</tr>
			</table>
			<div>
				<!-- id를 hidden으로 해서 심기 -->
				<input type="hidden" name="id" value="<%=id %>"> <input
					type="submit" value="저장"> <a
					href="detail.jsp?id=<%=notice.getId()%>">취소</a>
				<!-- notice.getId() 대신 id를 바로 써줘도 됨 -->
			</div>
		</form>
	</section>
</main>
