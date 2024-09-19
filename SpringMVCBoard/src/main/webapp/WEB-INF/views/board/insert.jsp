<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form method = "post" action="/board/insert">
    작성자<br>
    <input type="text" name="writer"><br>
    제목<br>
    <input type="text" name="title"><br>
    내용<br>
    <textarea name="content" required style="resize: none;"></textarea><br>
    <input type="submit" value="글쓰기">
</form>

</body>
</html>