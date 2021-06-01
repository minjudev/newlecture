<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- // MVC 패턴 방법론
	
	// 코드량이 많아지면 해당 코드블럭이 여러 군데에 흩어져있을 것임
	// 흩어져있지만 한 번에 봐야할 코드
	// 모아놓고 보는 게 좋겠다
	// 모아놓고 보니까 양분화되어보임 -> 해당 코드블럭의 코드는 자바 코드층, 밑은 html 코드층
	// 산발적으로 흩어져있는 코드 : 스파게티 코드
	
	// 자바 코드가 미리 컴파일되지 않음
	// 미리 컴파일 x -> 수행 성능에 문제
	// 사용자에게 jsp가 요청되면 그 때야 jasper가 서블릿을 만들고 그 이후에 자바 코드가 컴파일되게 됨
	// html 수정하는 사람과 자바 코드 수정하는 사람이 같은 문서 공유 -> 효율적 X

	// 모든 코드가 다 Jasper가 필요한가?
	// 업데이트, 삭제, 폼 제출 시 jasper 필요X
	// jasper는 get 요청 시에만 필요!
	// 다시 서블릿으로 가고 jasper는 문서 출력이 필요할 때만 옵션으로 쓰자!
	// forward: 내가 작업한 것을 너가 이어서 작업해(jasper의 일 축소 가능) -->

<%-- <%
	Notice notice = (Notice)request.getAttribute("notice"); // 반환 타입이 오브젝트여서 형변환 필요
	// 여기서 자바 코드가 사라지지 않은 문제점, 완전히 분리되었다고 보기 힘듦
%>
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../js/list.js"></script>
</head>

<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <h1 class="logo"><img src="../../images/nlogo.png" alt="뉴렉처 온라인"></h1>
                <section>
                    <h1 class="d-none">헤더</h1>
                    <nav class="main-menu">
                        <h1 class="d-none">메인 메뉴</h1>
                        <ul>
                            <li><a class="redsun" href="" dir="ltr">학습가이드</a></li>
                            <li><a href="">강좌선택</a></li>
                            <li><a href="">AnswerIs</a></li>
                        </ul>
                    </nav>
                
                    <section class="lecture-search-form">
                        <h1 class="d-none">강좌 검색 폼</h1>
                        <form>
                            <fieldset>  <!-- 다른 필드셋과 구분해주고 싶을 때 사용 -->
                                <legend class="d-none">과정 검색 필드</legend> <!-- 필드셋에 대한 라벨 -->
                                <label>과정 검색</label>
                                <input id="a1" type="text" value="test">
                                <input class="button" type="submit" value="검색">
                            </fieldset>  
                        </form>
                    </section>

                    <nav class="member-menu">
                        <h1 class="d-none">회원 메뉴</h1>
                        <ul>
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="member/login.html">로그인</a></li>
                            <li><a href="">회원가입</a></li>
                        </ul>
                    </nav>
                
                    <nav class="customer-menu">
                        <h1 class="d-none">고객센터 메뉴</h1>
                        <ul>
                            <li><a class="button mypage-button" href="">마이페이지</a></li>
                            <li><a class="button customer-button" href="">고객센터</a></li>
                        </ul>
                    </nav>
                </section>
            </div>
        </header>

        <div id="visual">
            <div class="float-content"></div>
        </div>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <h1 id="aside-title">고객센터</h1>
                    <nav class="main-aside-menu">
                        <h1 id="memberMenu">고객센터 메뉴</h1>
                        <ul>
                            <li><a href="list.html">공지사항</a></li>
                            <li><a class="current" href="">자주하는 질문</a></li>
                            <li><a href="">수강문의</a></li>
                            <li><a href="">이벤트</a></li>
                        </ul>
                    </nav>

                    <nav class="aside-menu recommend-aside-menu">
                        <h1>협력업체</h1>
                        <ul>
                            <li><a class="img img-notepubs" href="">노트펍스</a></li>
                            <li><a class="img img-namoolab" href="">나무랩연구소</a></li>
                        </ul>
                    </nav>        
                </aside>

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
                        		<th>제목</th>  <!-- 컬럼 내에서의 제목: th -->
                        		<td colspan="3">${notice.title}<%-- <%=notice.getTitle() %> --%></td> <!-- DB에 해당되는 내용 나오게 하기 -->
<!--                         		JSP Expression Language 사용, getTitle할 때는 get 지우고 대문자 소문자로 바꾸기
 -->                        	</tr>
                        	<tr>
                        		<th>작성일</th>
                        		<td colspan="3"><fmt:formatDate value="${notice.regDate}" pattern="yy.MM.dd hh:mm a"/></td>
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
                        		<!-- forTokens은 잘려진 문자열의 개수만큼 반복해줌 -->
                        		<c:forTokens var="fileName" items="${notice.files}" delims="," varStatus="st"> <!-- varStatus: 상태값 알아내기 -->
                        			<a download href="/upload/${fileName}">${fileName}</a>
                        			<c:if test="${!st.last }"> <!-- last가 아닌 경우 -->
                        			  |
                        			</c:if>
                        		</c:forTokens>
                        		</td>
                        	</tr>
                        	<tr>
                        		<td colspan="4">
                        			${notice.content}
                        		</td>
                        	</tr>
                        </table>
						<div>
							<a href="list">목록</a>
							<a href="edit?id=${notice.id}">수정</a>
							<!-- delete할 때 쿼리스트링과 함께 get 방식으로 보냄, 그래서 서블릿에서도 doGet 메소드로 처리 -->
							<a href="del?id=${notice.id}" onclick="if(!confirm('정말 삭제하시겠습니까?')) return false;">삭제</a> <!-- doGet으로 처리 -->
                        	<!-- true를 반환하면 기본 행위(a 링크) 동작, return false: e.preventDefault()라고 생각하기-->
                        </div>
                    </section>
                </main>
            </div>
        </div>

        <footer id="footer">
            <div class="float-content">
                <!-- 회사정보
                Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
            </div>
        </footer>
    </div>
</body>
</html>