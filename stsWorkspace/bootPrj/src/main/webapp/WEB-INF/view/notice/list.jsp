<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
      
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../js/list.js"></script>
</head>

<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <h1 class="logo"><img src="../images/nlogo.png" alt="뉴렉처 온라인"></h1>
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
                        <section class="breadcrumb">
                            <h1 class="d-none">경로</h1>
                            <ol>
                                <li>home</li>
                                <li>고객센터</li>
                                <li>공지사항</li>
                            </ol>
                        </section>

                        <section>
                            <h1 class="main-title">공지사항${a }</h1>
                            
                            <section class="search-form">
                                <h1 class="d-none">검색폼</h1>
                                <form action="list" method="get"> <!-- action을 생략하면 현재 url과 같은 주소로 요청이 감 -->
                                	<label class="d-none">검색 분류</label>
                            <%--     	<%
                                		String selectedTitle = "";
                                		String selectedWriterId = "";
                                		
                                		if(field.equals("title"))
                                			selectedTitle = "selected";
                                		
                                		if(field.equals("writer_id"))
                                			selectedWriterId = "selected";
                                	%> --%>
                                	<select name="f">
                                		<option value="">분류 선택</option> <!-- value를 비워놓으면 분류 선택칸을 선택 안했음을 알 수 있음 -->
                                		<option ${param.f=='title'?'selected':'' } value="title">제목</option> <!-- value 지정 시 value 값이 감, value 지정하지 않으면 태그 내의 값인 '제목'이 감 -->
                             			<option ${param.f=='writer_id'?'selected':'' } value="writer_id">작성자</option>
                                	</select>
                                	<label class="d-none">검색어</label>
                                	<input type="text" name="q" value="${param.q}">
                                	<input type="submit" value="검색">
                                </form>
                            </section>
                            
                            <table class="table mt-3">
                                <thead>
                                    <tr>
                                        <td class="w-1">번호</td>
                                        <td class="truncate">제목</td>
                                        <td class="w-2">작성자</td>
                                        <td class="w-2">작성일</td>
                                        <td class="w-1">조회수</td>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <!-- 제어가 필요한 코드는 어떻게 할까? -->
                                <!-- forEach 태그 앞에 접두사를 써서 단순한 출력 태그가 아닌 for문을 위한 태그로 jasper가 인식하게 하기-->	
                               	
                               	<c:forEach var="n" items="${list}"> <!-- //컬렉션이 가지는 개수만큼 반복, n이라는 키값으로 담아줌 -->
                                    <tr>
                                        <td class="w-1">${n.id}</td>
                                        <td class="truncate text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
                                        <td class="w-2">${n.writerId}</td>
                                        <td class="w-2"><fmt:formatDate value="${n.regDate}" pattern="yy.MM.dd"/></td>
                                        <td class="w-1">${n.hit}</td>
                                    </tr> 
                               	
                               	</c:forEach>
                               	
                                </tbody>
                            </table>
                            
                            <div>
                            	<a href="reg">글쓰기</a>
                            </div>
                            
                        </section>

                        <section class="page-status mt-3">
                            <h1 class="d-none">현재 페이지 정보</h1>                            
                            <div>
                            	<c:set var="lastPage" value="${count/10 + (count % 10 == 0 ? 0 : 1)}" />
                            	<c:set var="lastPage" value="${fn:substringBefore(lastPage, '.')}" />
                                <span class="text-strong">${(empty param.p)?1:param.p}</span> / ${lastPage} pages
<!--                                 						 empty: null & 빈 문자열 
 -->                            </div>
                        </section>
                        <nav class="pager mt-3">
                            <h1 class="d-none">페이저</h1>
                            <div class="button">이전</div>
                            <ul>
                            <c:set var="page" value="${empty param.p ? 1: param.p }" /> <!-- 기본값 대입 -->
                            <c:forEach var="i" begin="1" end="10">
                            	<c:if test="${i <= lastPage}">
                            		<li><a class="${(page == i) ? 'text-strong' : ''}" href="list?p=${i}&f=${param.f}&q=${param.q }">${i}</a></li> <!--이렇게 해서 사용자가 검색한 결과 내에서 paging 할 수 있게 하기-->
                            	</c:if>
                            </c:forEach>
                            
                            <%-- <%for(int i=0; i<5; i++) {%> <!-- 1. 횟수를 수정 -->
                            	<!-- 2. lastPage보다 출력되는 게 클 경우 안 나오게 if문 조건처리 -->
                            	<%if(lastPage >= i+1)  {%> 
                                	<li><a class="<%=page_ == i+1 ? "text-strong" : "" %>" href="list?p=<%=i+1 %>&f=<%=field %>&q=<%=query %>"><%=i+1 %></a></li>
                            	<%} %>
                            <%} %>  --%>                                
	                        </ul>
                            <div class="button">다음</div>
                        </nav>
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