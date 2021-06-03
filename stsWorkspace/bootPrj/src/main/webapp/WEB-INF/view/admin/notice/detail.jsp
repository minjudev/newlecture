<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<table border="1">
			<tr>
				<th>제목</th>
				<!-- 컬럼 내에서의 제목: th -->
				<td colspan="3">${notice.title}<%-- <%=notice.getTitle() %> --%></td>
				<!-- DB에 해당되는 내용 나오게 하기 -->
				<!--                         		JSP Expression Language 사용, getTitle할 때는 get 지우고 대문자 소문자로 바꾸기
 -->
			</tr>
			<tr>
				<th>작성일</th>
				<td colspan="3"><fmt:formatDate value="${notice.regDate}"
						pattern="yy.MM.dd hh:mm a" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${notice.writerId}</td>
				<th>조회수</th>
				<td>${notice.hit}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
					<!-- forTokens은 잘려진 문자열의 개수만큼 반복해줌 --> <c:forTokens var="fileName"
						items="${notice.files}" delims="," varStatus="st">
						<!-- varStatus: 상태값 알아내기 -->
						<a download href="/upload/${fileName}">${fileName}</a>
						<c:if test="${!st.last }">
							<!-- last가 아닌 경우 -->
                        			  |
                        			</c:if>
					</c:forTokens>
				</td>
			</tr>
			<tr>
				<td colspan="4">${notice.content}</td>
			</tr>
		</table>
		<div>
			<a href="list">목록</a> <a href="edit?id=${notice.id}">수정</a>
			<!-- delete할 때 쿼리스트링과 함께 get 방식으로 보냄, 그래서 서블릿에서도 doGet 메소드로 처리 -->
			<a href="del?id=${notice.id}"
				onclick="if(!confirm('정말 삭제하시겠습니까?')) return false;">삭제</a>
			<!-- doGet으로 처리 -->
			<!-- true를 반환하면 기본 행위(a 링크) 동작, return false: e.preventDefault()라고 생각하기-->
		</div>
	</section>
</main>