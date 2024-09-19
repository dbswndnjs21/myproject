<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-28
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>home!!!</h1>
<ul>
    <li><a href="myusers/insert">회원 가입</a> </li>
    <li><a href="users/list">회원 목록</a> </li>

    <c:choose>
        <c:when test="${empty sessionScope.username}">
            <li><a href="/login">로그인</a> </li>
        </c:when>
        <c:otherwise>
            ${username}님 반갑습니다!
            <li><a href="/logout">로그아웃</a> </li>
        </c:otherwise>
    </c:choose>
</ul>
    <a href="<%=request.getContextPath()%>/">홈으로</a>
</body>
</html>
