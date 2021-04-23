<%@page import="com.newlecture.web.entity.Member"%>
<%@page import="com.newlecture.web.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 원래는 import하고 싶은 부분의 패키지명을 전부 적어줘야 함 -> Ctrl + space로 대신
	MemberService memberService = new MemberService();
	Member[] list = memberService.getList();
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
                    <nav class="main-menfu">
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
                    	<% for(int i=0; i<5; i++) {%>
	                    	<div>hello</div>                    	
                    	<% }%>
                    	
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
                                <h1 class="d-none">검색폼</h1>
                                <form action=""></form>
                                <form action=""></form>
                                <div></div>
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
                                	<% for(int i=0; i<list.length; i++) {%>
	                                    <tr>
	                                        <td class="w-1"><%=i+1%></td>
	                                        <td class="truncate text-align-left"><a href=""><%=list[i].getNickName()%></a></td>
	                                        <td class="w-2">newlec</td>
	                                        <td class="w-2">2020-12-12</td>
	                                        <td class="w-1">1351</td>
	                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </section>

                        <section class="page-status mt-3">
                            <h1 class="d-none">현재 페이지 정보</h1>
                            <div>
                                <span class="text-strong">1</span> / 2 pages
                            </div>
                        </section>

                        <nav class="pager mt-3">
                            <h1 class="d-none">페이저</h1>
                            <div class="button">이전</div>
                            <ul>
                                <li><a class="text-strong" href="">1</a></li>
                                <li>2</li>
                                <li>3</li>
                                <li>4</li>
                                <li>5</li>
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