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
    <th>회원번호</th>
    <th>이름</th>
    <th>전화번호</th>
    <th>주소</th>
    <th>가입일</th>
    <th>수정</th>
    <th>삭제</th>
</tr>
<c:forEach var="mem" items="${list}">
    <tr>
        <td>${mem.num}</td>
        <td>${mem.name}</td>
        <td>${mem.phone}</td>
        <td>${mem.addr}</td>
        <td>${mem.regdate}</td>
        <td><a href="/members/update?num=${mem.num}">수정</a> </td>
        <td><a href="/members/delete?num=${mem.num}">삭제</a> </td>
    </tr>
</c:forEach>
</table>
<a href="/">홈으로</a>
</body>
</html>
