<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  isELIgnored="false" %>  
    
    
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id ="m" class ="day0614.MemberBean" scope ="page"/>
<jsp:setProperty name="m" property ="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
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
<td><%=m.getId() %></td>
<td><%=m.getPwd() %></td>
<td><%=m.getName() %></td>
<td><%=m.getEmail() %></td>
</tr>
<tr align ="center">
<td>${m.id }</td>
<td>${m.pwd }</td>
<td>${m.name }</td>
<td>${m.email }</td>
</tr>

</table>
</body>
</html>