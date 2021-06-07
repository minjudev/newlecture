<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    
    <c:set var="title" value="${title }"></c:set>  <!-- SubLayoutPreparer에서 심어준 title -->
    <title>${title}</title> 
    
    <!-- tiles.xml에서 고정으로 설정한 값 출력(tiles:getAsString name="") -->
    <c:set var="js"><tiles:getAsString name="js" /></c:set> <!-- 태그가 태그를 감싸지 않게 하기 -->    
    <script type="text/javascript" src="/js/admin/notice/${js}"></script>
</head>

<body>
    <div id="root">
        <!-- header 영역 -->
        <tiles:insertAttribute name="header" />

        <div id="visual">
            <div class="float-content"></div>
        </div>

        <div id="body">
            <div class="float-content">
               <!-- asdie 영역, admin에서만 사용할 aside이므로 admin/inc 안에 두기 -->
			   <tiles:insertAttribute name="aside" />
				

               <!-- main 영역 -->
			   <tiles:insertAttribute name="main" />               
            </div>
        </div>

        <!-- footer 영역 -->
	    <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>