<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="result.jsp" method="post">
ID:<input type="text" name ="userID"><br>
PassWord:<input type="password" name ="userPw"><br>
<input type="submit" value="로그인">
<input type="reset" value="다시입력">

</form>

</body>
</html>