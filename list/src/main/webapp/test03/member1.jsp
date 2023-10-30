<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored ="false" %>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
    
 
<%

request.setCharacterEncoding("utf-8");
String id =request.getParameter("id");
String pwd =request.getParameter("pwd");
String name =request.getParameter("name");
String email =request.getParameter("email");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>
<table align ="center" border="1">
<tr align ="center" bgcolor ="#d90368">
<td width ="7%"><b>아이디</b></td>
<td width ="7%"><b>비밀번호</b></td>
<td width ="7%"><b>이름</b></td>
<td width ="7%"><b>이메일</b></td>

</tr>

<tr align="center">
<td>${param.id}</td>
<td>${param.pwd}</td>
<td>${param.name}</td>
<td>${param.email}</td>

</tr>
</table>
</body>
</html>