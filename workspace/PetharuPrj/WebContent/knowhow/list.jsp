<%@page import="com.petharu.web.entity.Knowhow"%>
<%@page import="java.util.List"%>
<%@page import="com.petharu.web.service.KnowhowService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	KnowhowService knowhowService = new KnowhowService();
	List<Knowhow> list = knowhowService.getList();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="list.css" type="text/css" rel="stylesheet">
<!--     <script type="text/javascript" src="list.js"></script>
 -->    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <div class="flex align-center">
                    <a href="" class="logo-title-container">
                        <img src="../images/logo.png">
                    </a>
                    <nav class="main-menu">   
                            <h1 class="d-none">메인메뉴</h1>
                            <ul>
                                <li><a href="../../myhome/list.html">우리집</a></li>
                                <li><a href="../../friends/list.html">이웃집</a></li>
                                <li><a href="../../pet-management/mypet/list.html">내 동물 관리</a></li>
                                <li><a href="../notice/list.html">커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="../../member/profile-edit.html">MyPage</a></li>
                        <li><a href="../../../login.html">LogOut</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <nav class="aside-menu">
                        <h1 class="d-none">커뮤니티 메뉴</h1>
                        <ul>
                            <li><a href="../notice/list.html">공지사항</a></li>
                            <li><a class="current-page" href="list.html">노하우</a></li>
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <section>
                        <section class="pet-selecting-btn">
                            <button class="font">강아지</button>
                            <button class="font">고양이</button>
                        </section>
                        <section class="category-btn">
                        	<select>
                        	    <option>카테고리 선택</option>
                        		<option>건강</option>
	                      		<option>교육/훈련</option>
	                      		<option>급여</option>
	                      		<option>생활</option>
	                      		<option>놀이</option>
	                      		<option>의료</option>
                        	</select>
                        </section>
                        <section class="knowhow-upload-btn">
                            <h1 class="d-none">노하우 게시글 등록</h1>
                            <a href="upload.html"><button class="font">노하우 등록하기</button></a>
                        </section>
                    </section>
                    <div class="knowhow-list">
                        <h1 class="d-none">노하우 게시글 목록</h1>
                        <!-- 
                        1. KnowhowService 생성 //
                        	- DB와 연동시켜 데이터 가져오기 
                        2. Knowhow 클래스 생성 //
                        3. KnowhowList 생성 //
                        	- 화면에 출력할 데이터를 얻는 곳
                        4. list.jsp
                        	- KnowhowList에서 데이터를 얻어와 화면에 출력하는 로직 짜기
                        -->
                        <% for(Knowhow k : list) { %>
	                        <div>
	                            <div class="img-area">
	                                <a href="detail.jsp?id=<%=k.getId()%>">
	                                <img class="img-pet" src="../images/cat-rest1.jpg">
	                                </a>
	                            </div>
	                            <div class="text-area">
	                            	<div class="knowhow-info">
	                            		<ul>
	                            			<li>
	                            				<img src="../images/view.png">
	                            				<span><%=k.getHit()%></span>
	                            			</li>
	                            			<li>
	                            				<img src="../images/heart.png">
	                            				<span><%=k.getLike()%></span>
	                            			</li>
	                            			<li>
	                            				<img src="../images/comment.png">
	                            				<span>3</span>
	                            			</li>
	                            		</ul>
	                            	</div>
	                                <div class="knowhow-title"><a href="detail.jsp?id=<%=k.getId()%>"><%=k.getTitle()%></a></div>
	                                <section class="flex">
	                                    <div class="img-member"></div>
	                                    <span class="id"><%=k.getUserId()%></span>
	                                </section>
	                            </div>
	                        </div>	
	                	<% } %>
                    </div>
                    <nav class="pager">
                        <h1 class="d-none">현재 페이지 정보</h1>
                        <a href=""><img class="prev" src="../images/left-arrow.png" alt=""></a>
                        <ul>
                            <li><a href="">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">4</a></li>
                        </ul>
                        <a href=""><img class="next" src="../images/right-arrow.png" alt=""></a>
                    </nav>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>
    </div>        
</body>
</html>