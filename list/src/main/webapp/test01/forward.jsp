<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    request.setAttribute("address","서울시 강남구");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
<table align ="center" border="1">
<tr align ="center" bgcolor ="#d90368">
<td width ="20%"><b>아이디</b></td>
<td width ="20%"><b>비밀번호</b></td>
<td width ="20%"><b>이름</b></td>
<td width ="20%"><b>이메일</b></td>
<td width ="20%"><b>주소</b></td>
</tr>

<tr align=center>
<td>${param.id}</td>
<td>${param.pwd}</td>
<td>${param.name}</td>
<td>${param.email}</td>
<td>${requestScope.address}</td>
</tr>
</table>
</body>
</html>