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
<h1>쇼핑몰 회원 등록</h1>
<form action="Controller">
<input type="hidden" name="flag" value="i"/>
<table>
<tr><td>회원번호(자동발생)</td><td><input type="text" value="${custno }" name="custno" required/></td></tr>
<tr><td>회원성명</td><td><input type="text" value="" name="custname"required/></td></tr>
<tr><td>회원전화</td><td><input type="text" value="" name="phone"required/></td></tr>
<tr><td>회원주소</td><td><input type="text" value="" name="address"required/></td></tr>
<tr><td>가입일자</td><td><input type="text" value="" name="joindate"required/></td></tr>
<tr><td>고객등급[a:vip,b:일반,c:직원]</td><td><input type="text" value="" name="grade"required/></td></tr>
<tr><td>도시코드</td><td><input type="text" value="" name="city"required/></td></tr>
<tr><td><input type="submit" value="등록"/><input type="button" value="조회" onclick="location.href='Controller?flag=s'"/></td></tr>
</table>
</form>
</article>
</section>
<jsp:include page="footer.html"/>
</body>
</html>