<!-- 실행 코드는 코드 블럭에 넣어주기 -->
<%
	int result = 33;
	// request / response 
	// pageContext / request / session / application: 저장소(내가 처리했던 내용들을 저장할 수 있음)
	// out / page
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
				<input type="submit" value="ë§ì"><span><% out.print(result); %></span>
			</form>
		</div>
	</section>
</body>
</html>