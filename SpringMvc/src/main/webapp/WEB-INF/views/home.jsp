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
    <li><a href="fortune?day=1">오늘의 운세</a> </li>
    <li><a href="fortune?day=2">내일의 운세</a> </li>
    <li><a href="<%=request.getContextPath()%>/members/insert">회원 가입</a> </li>
    <li><a href="<%=request.getContextPath()%>/members/list">회원 목록</a> </li>
</ul>
<form method="post" action="/sum">
    수1 <input type="text" name="num1"> <br>
    수2 <input type="text" name="num2"> <br>
    <input type="submit" value="두수 합 구하기">
    <span>두수의 합은 : ${result} </span> <br>

    <a href="<%=request.getContextPath()%>/">홈으로</a>
</form>
</body>
</html>
