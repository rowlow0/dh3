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
<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.custno}</td>
<td>${list.custname}</td>
<td>
<c:if test="${list.grade eq 'a' }">vip</c:if>
<c:if test="${list.grade eq 'b' }">일반</c:if>
<c:if test="${list.grade eq 'c' }">직원</c:if>
</td>
<td>${list.price}</td>
</tr>
</c:forEach>
</tr>
</table>
</article>
</section>
<jsp:include page="footer.html"/>
</body>
</html>