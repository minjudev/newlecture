<%@page import="com.petharu.web.entity.Knowhow"%>
<%@page import="com.petharu.web.service.KnowhowService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id_ = request.getParameter("id");
	int id = Integer.parseInt(id_);
	
	KnowhowService knowhowService = new KnowhowService();
	Knowhow knowhow = knowhowService.get(id); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="detail.css" type="text/css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
<!--     <script src="detail.js"></script>
 --></head>
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
                    <section class="knowhow-header"> 
	                    <h1 class="title"><%= knowhow.getTitle() %></h1>
	                    <div class="knowhow-info">
	                  		<ul>
	                  			<li>
	                  				<img src="../images/view.png">
	                  				<span><%= knowhow.getHit() %></span>
	                  			</li>
	                  			<li>
	                  				<img src="../images/heart.png">
	                  				<span><%= knowhow.getLike() %></span>
	                  			</li>
	                  			<li>
	                  				<img src="../images/comment.png">
	                  				<span>3</span>
	                  			</li>
	                  		</ul>
	                  	</div>
                    </section>
                    <section class="margin flex">
                        <section class="member-info flex"> 
                            <h1 class="d-none">회원 정보</h1>
                            <div class="img-member"></div> 
                            <span class="id"><%= knowhow.getUserId() %></span>
                        </section>
                        <section class="pet-selecting-btn">
                            <button class="pet-btn font">강아지</button>
                            <button class="pet-select pet-btn font">고양이</button>
                        </section>
                    </section>
                    <section>
                        <div class="img-area">
                            <img class="img-pet" src="../images/cat-rest1.jpg">
                        </div>
                        <div class="write-content"> 
                            <textarea class="text-area font" name="" ><%= knowhow.getContent() %>
                            </textarea>
                        </div>
                    </section>
                    <section class="button-menu margin">
                        <h1 class="d-none">버튼</h1>
                        <button class="font"><a href="edit.html">수정하기</a></button>
                        <button class="delete-btn font">삭제하기</button>
                    </section>
                    <hr>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>

        <div class="modal-section">
            <div class="black-bg d-none"></div>
            <div class="modal d-none">
                <div class="modal-content">
                    게시글을 삭제하시겠습니까?
                </div>
                <section class="modal-button-menu">
                    <h1 class="d-none">모달창 버튼</h1>
                    <button class="modal-btn modal-close">취소</button>
                    <button class="modal-btn">확인</button>
                </section>
                <div>
                    <a class="modal-close" href="#"><img class="close-btn" src="../images/close-button.png" alt=""></a>
                </div>
            </div>
        </div>
    </div>        
</body>
</html>