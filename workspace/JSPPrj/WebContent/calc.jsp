<%-- 
1. <%= %> 
2. <%! %>
3. <%@ %>
--%>

<!-- 지시 블럭: 코드가 아니라 설정 사항임을 알려주는 코드 블럭 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 실행 코드는 코드 블럭에 넣어주기 -->
<%
	// response.setCharacterEncoding("UTF-8"); // 제대로 동작하지 않음
	// Jasper가 자기 마음대로 기본 인코딩(ISO-8859-1)으로 보냄
	// out이라는 출력객체를 뽑기 전에 인코딩을 먼저 설정해야 할 필요성
	
	int result = 115;
	// request / response 
	// pageContext / request / session / application: 저장소(내가 처리했던 내용들을 저장할 수 있음)
	// out / page
%>

<!-- 클래스의 멤버 함수로서 함수를 추가
아래 코드 블럭의 코드를 서비스 함수 바깥에 놓게 함 -->
<%!
	public int add(int x, int y) {
		return x + y;
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<h1>계산기</h1>
			<form action="/add">
				<input type="text" name="x">+<input type="text" name="y"><br>
				<input type="submit" value="덧셈"><span><%=result%></span>
			</form>
		</div>
	</section>
</body>
</html>