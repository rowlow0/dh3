<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css"/>
</head>
<body>
<jsp:include page="header.html"/>
<%@include file="nav.jsp" %>
<section>
<article>
<h1>쇼핑몰 회원관리 프로그램</h1>
<p>쇼핑몰 회원정보의 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
프로그램 작성순서<br>
1.회원정보 테이블을 생선한다.<br>
2.매출정보 테이블을 생성한다.<br>
3.회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.<br>
4.회원정보 입력 화면프로그램을 작성한다.<br>
5.회원정보 조회 프로그램을 작성한다.<br>
6.회원매출정보 조회 프로그램을 작성한다.<br>
</article>
</section>
<jsp:include page="footer.html"/>
</body>
</html>