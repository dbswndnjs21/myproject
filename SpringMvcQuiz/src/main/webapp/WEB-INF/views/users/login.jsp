<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-29
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 로그인</h1>
<form method="post" action="/login">
    아이디 <input type="text" name="username"> <br>
    비밀번호 <input type="password" name="password"> <br>
    ${errMsg}<br>
    <input type="submit" value="로그인">
</form>
</body>
</html>
