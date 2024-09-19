<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-28
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원목록</h1>
<table border="1">
    <tr>
        <th>회원이름</th>
        <th>비밀번호</th>
        <th>이메일</th>
    </tr>
    <c:forEach var="mem" items="${list}">
        <tr>
            <td>${mem.username}</td>
            <td>${mem.password}</td>
            <td>${mem.email}</td>
<%--            <td><a href="/users/update?num=${mem.num}">수정</a> </td>--%>
<%--            <td><a href="/users/delete?num=${mem.num}">삭제</a> </td>--%>
        </tr>
    </c:forEach>
</table>
<a href="/">홈으로</a>
</body>
</html>
