<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="com.newlecture.web.entity.Member"%>
<%@page import="com.newlecture.web.service.MemberService"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

		<form class="form" action="reg" method="post"
			enctype="multipart/form-data">
			<!-- 서블릿을 처리기로 해서 사용자가 등록한 내용을 저장할 수 있도록 서버에 post로 보내고, 서버가 redirect해서 등록 내용이 반영된 목록 페이지 보여주게 하기 -->
			<table border="1">
				<tr>
					<th>제목</th>
					<!-- 컬럼 내에서의 제목: th -->
					<td colspan="3"><input type="text" name="title" value=""></td>
					<!-- DB에 해당되는 내용 나오게 하기 -->
				</tr>
				<!-- <tr>
	                        		<td colspan="4">
	                        		취미 : 
	                        		<label>십자수</label>
	                        		<input type="checkbox" value="1" name="h">
	                        		<label>등산</label>
	                        		<input type="checkbox" value="2" name="h">
	                        	</tr> -->
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><input type="file" name="f"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><input type="file" name="f"></td>
				</tr>
				<tr>
					<td colspan="4"><textarea contenteditable="true" rows="20"
							cols="80" name="content"></textarea></td>
				</tr>
			</table>
			<div class="progress-status">
				<div>
					<span class="bar">0%</span>
				</div>
				<ul>

				</ul>
			</div>
			<section id="dnd-section">
				<style>
#dnd-section .upload-box {
	width: 500px;
	height: 150px;
	border: 1px solid gray;
	box-shadow: 2px 3px 9px hsl(0, 0%, 47%);
	padding: 10px;
}

#dnd-section .upload-box.valid {
	background: green;
}

#dnd-section .upload-box.invalid {
	background: red;
}

.progress-status {
	font-size: 20px;
	width: 583px;
}

.progress-status .bar {
	display: inline-block;
	width: 0%;
	height: 20px;
	background: gold;
	border-radius: 10px;
	text-align: right;
	font-weight: bold;
	color: #fff;
	transition: 0.5s;
}
</style>
				<h1>파일 업로드 - DND & Trigger</h1>
				<div class="upload-box">
					<button class="btn-sel">파일 선택</button>
					<!--.btn-file의 이벤트를 .btn-sel로 견인하는 방식(트리거)으로 사용-->
					<input class="btn-file d-none" type="file">
					<!--사용자가 파일에 직접 접근할 수 있게 해야 함-->
				</div>
			</section>

			<div>
				<input type="submit" value="저장"> <a href="list.jsp">취소</a>
			</div>
		</form>
	</section>
</main>