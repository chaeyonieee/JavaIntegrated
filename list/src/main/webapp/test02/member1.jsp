<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored ="false"%>
 
<%
String id = (String)request.getAttribute("id");
String pwd =(String)request.getAttribute("pwd");
String name =(String)session.getAttribute("name");
String email =(String)application.getAttribute("email");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align ="center" width="100%">
<tr align ="center" bgcolor ="#99ccff">
<td width ="7%">아이디</td>
<td width ="7%">비밀번호</td>
<td width ="5%">이름</td>
<td width ="11%">이메일</td>

</tr>
<tr align ="center">
<td><%=id %></td>
<td><%=pwd %></td>
<td><%=name %></td>
<td><%=email %></td>
</tr>
<tr align ="center">
<td>${id }</td>
<td>${pwd }</td>
<td>${name }</td>
<td>${email }</td>
</tr>

</table>
</body>
</html>