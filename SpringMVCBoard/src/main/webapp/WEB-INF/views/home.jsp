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

    <li><a href="<%=request.getContextPath()%>/board/insert">회원 가입</a> </li>
    <li><a href="<%=request.getContextPath()%>/board/list">회원 목록</a> </li>
</ul>

    <a href="<%=request.getContextPath()%>/">홈으로</a>

</body>
</html>
