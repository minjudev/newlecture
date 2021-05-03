<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="com.newlecture.web.entity.Member"%>
<%@page import="com.newlecture.web.service.MemberService"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String p = request.getParameter("p");
	String f = request.getParameter("f");
	String q = request.getParameter("q");
	
	System.out.println(p);
	System.out.println(f);
	System.out.println(q);
	
	// 변수 초기화: 기본 값을 설정하는 것
	int page_ = 1; // jsp가 가지고 있는 내장 변수가 페이지라는 이름을 사용하고 있어서 오류 발생
	String field = "title";
	String query = "";
	
	// 사용자가 입력한 값으로 대치
	if(p != null && !p.equals(""))
		page_ = Integer.parseInt(p);
	
	if(f != null && !f.equals(""))
		field = f;
	
	if(q != null && !q.equals(""))
		query = q;

	// 원래는 import하고 싶은 부분의 패키지명을 전부 적어줘야 함 -> Ctrl + space로 대신
	NoticeService noticeService = new NoticeService();
	List<Notice> list = noticeService.getList(page_, field, query); // 사용자가 검색한 결과 얻게 하기
 %>    

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
                <h1 class="logo"><img src="../images/logo.png" alt="뉴렉처 온라인"></h1>
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
                            <h1 class="main-title">공지사항</h1>
                            
                            <section class="search-form">
                                <h1>검색폼</h1>
                                <form action="list.jsp" method="get"> <!-- action을 생략하면 현재 url과 같은 주소로 요청이 감 -->
                                	<label class="d-none">검색 분류</label>
                                	<%
                                		String selectedTitle = "";
                                		String selectedWriterId = "";
                                		
                                		if(field.equals("title"))
                                			selectedTitle = "selected";
                                		
                                		if(field.equals("writer_id"))
                                			selectedWriterId = "selected";
                                	%>
                                	<select name="f">
                                		<option value="">분류 선택</option> <!-- value를 비워놓으면 분류 선택칸을 선택 안했음을 알 수 있음 -->
                                		<option <%=selectedTitle %> value="title">제목</option> <!-- value 지정 시 value 값이 감, value 지정하지 않으면 태그 내의 값인 '제목'이 감 -->
                             			<option <%=selectedWriterId %> value="writer_id">작성자</option>
                                	</select>
                                	<label class="d-none">검색어</label>
                                	<input type="text" name="q" value="<%=query%>">
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
                                	<% for(Notice n : list) {%>
	                                    <tr>
	                                        <td class="w-1"><%=n.getId()%></td>
	                                        <td class="truncate text-align-left"><a href=""><%=n.getTitle()%></a></td>
	                                        <td class="w-2"><%=n.getWriterId()%></td>
	                                        <td class="w-2"><%=n.getRegDate()%></td>
	                                        <td class="w-1"><%=n.getHit()%></td>
	                                    </tr> 
                                    <% }%>
                                </tbody>
                            </table>
                        </section>

                        <section class="page-status mt-3">
                            <h1 class="d-none">현재 페이지 정보</h1>
                            <% 
                            	int count = noticeService.getCount(field, query);
                            	int lastPage = count / 10 +  (count % 10 == 0 ? 0 : 1); // 
                            %>
                            <div>
                                <span class="text-strong"><%=page_ %></span> / <%=lastPage %> pages 
                            </div>
                        </section>
                        <nav class="pager mt-3">
                            <h1 class="d-none">페이저</h1>
                            <div class="button">이전</div>
                            <ul>
                            <%for(int i=0; i<5; i++) {%>
                                <li><a class="<%=page_ == i+1 ? "text-strong" : "" %>" href="list.jsp?p=<%=i+1 %>&f=<%=field %>&q=<%=query %>"><%=i+1 %></a></li> <!--이렇게 해서 사용자가 검색한 결과 내에서 paging 할 수 있게 하기-->
                            <%} %>    
                                
<!--                            <li><a href="list.jsp?p=5">5</a></li> 이렇게 하면 사용자가 검색한 결과에 페이징이 결합되지 못함  --> 
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