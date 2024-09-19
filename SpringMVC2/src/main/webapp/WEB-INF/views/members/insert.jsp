<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-28
  Time: 오후 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/members/insert">
    번호 <br>
    <input type="text" name="num"> <br>
    이름 <br>
    <input type="text" name="name"> <br>
    전화번호 <br>
    <input type="text" name="phone"> <br>
    주소 <br>
    <input type="text" name="addr"> <br>
    <input type="submit" value="가입">
</form>


</body>
</html>
