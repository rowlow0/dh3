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
<h1>회원목록조회/수정</h1>
<table>
<tr>
<th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th>
</tr>
<c:forEach var="list" items="${list }">
<tr>
<td><a href="Controller?flag=gotou&
custno=${list.custno }&
custname=${list.custname }&
phone=${list.phone }&
address=${list.address }&
joindate=${list.joindate }&
grade=${list.grade }&
city=${list.city }&
">${list.custno }</a></td>
<td>${list.custname }</td>
<td>${list.phone }</td>
<td>${list.address }</td>
<td>${list.joindate }</td>
<td>
<c:if test="${list.grade eq 'a' }">vip</c:if>
<c:if test="${list.grade eq 'b' }">일반</c:if>
<c:if test="${list.grade eq 'c' }">직원</c:if>
</td>
<td>${list.city }</td>
</tr>
</c:forEach>
</table>
</article>
</section>
<jsp:include page="footer.html"/>
</body>
</html>