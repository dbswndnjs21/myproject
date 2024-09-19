<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-08-30
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>상세글보기</h1>
<table border="1" width="600">
    <tr>
        <td>글번호</td><td>${vo.num}</td>
    </tr>
    <tr>
        <td>작성자</td><td>${vo.writer}</td>
    </tr>
    <tr>
        <td>제목</td><td>${vo.title}</td>
    </tr>
    <tr>
        <td>내용</td><td><div style="width: 400px;height: 200px">${vo.content}</div></td>
    </tr>
    <tr>
        <td>조회수</td><td>${vo.hit}</td>
    </tr>
    <tr><td>작성일</td><td>${vo.regdate}</td></tr>
    <tr><td>이전글</td><td><a href="/board/detail?num=${prev.num}">${prev.title}</a </td></tr>
    <tr><td>이전글</td><td><a href="/board/detail?num=${next.num}">${next.title}</a </td></tr>

</table>
</body>
</html>
