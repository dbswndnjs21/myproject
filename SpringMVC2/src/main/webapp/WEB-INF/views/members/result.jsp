<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-28
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<h1>결과 창</h1>
<c:choose>
    <c:when test="${code=='success'}">
        요청작업 성공 ㅋ
    </c:when>
    <c:otherwise>
        오류로 인한 실패ㅠ
    </c:otherwise>
</c:choose>
<br>
<a href="<%=request.getContextPath()%>/">홈으로</a>
</body>
</html>
