<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"
    isELIgnored ="false"%>
    
<%
request.setCharacterEncoding("utf-8");
%>  
<jsp:useBean id="m" class="day0614.MemberBean" />
<jsp:setProperty name ="m" property="*" /> 
<jsp:useBean id="addr" class="day0614.Address" />
<jsp:setProperty name="addr" property ="city" value="서울"/>
<jsp:setProperty name="addr" property ="zipcode" value="07654"/>
<%
m.setAddr(addr);
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
<td width ="7%"><b>도시</b></td>
<td width ="7%"><b>우편번호</b></td>


</tr>

<tr align="center">
<td>${m.id}</td>
<td>${m.pwd}</td>
<td>${m.name}</td>
<td>${m.email}</td>
<td><%=m.getAddr().getCity() %></td>
<td><%=m.getAddr().getZipcode() %></td>
</tr>
<tr align ="center">
<td>${m.id}</td>
<td>${m.pwd}</td>
<td>${m.name}</td>
<td>${m.email}</td>
<td>${m.addr.city}</td>
<td>${m.addr.zipcode}</td>
</tr>
</table>
</body>
</html>
