<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header id="header">
    <div class="float-content">
        <h1 class="logo"><img src="/images/nlogo.png" alt="뉴렉처 온라인"></h1>
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
                    <c:if test="${empty sessionScope.uid }"> <!-- el 태그는 pageContext -> request -> session 순으로 찾게 됨 -->
	                    <li><a href="/member/login">로그인</a></li> <!-- 세션에 uid가 존재하지 않을 때 -->
                    </c:if>
                   	<c:if test="${!empty sessionScope.uid }">
	                    <li><a href="/member/logout">로그아웃</a></li> <!-- 세션에 uid가 존재할 때 나오게 하기 -->
                    </c:if>
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
