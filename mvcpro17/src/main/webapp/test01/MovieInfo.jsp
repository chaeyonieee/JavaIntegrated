<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="java.util.*,movie.*"
    pageEncoding="UTF-8"
    isELIgnored="false"
    
  %>
    <%@ taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="contextPath" value="${pageContext.request.contextPath }" />
  <%
  request.setCharacterEncoding("utf-8");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보 출력창</title>
<style>
.clsl{
font-size:40px;
text-align:center;
}
.cls2{
font-size:20px;
text-align:center;

}
</style>

</head>
<body>
<p class="clsl">회원정보</p>
<table align ="center" border="1">
<tr align ="center" bgcolor="lightgreen">
<td width ="7% "><b>아이디</b></td>
<td width ="7% "><b>제목</b></td>
<td width ="7% "><b>장르</b></td>
<td width ="7% "><b>삽입</b></td>
<td width ="7% "><b>삭제</b></td>
</tr>
<c:choose>
<c:when test ="${empty moviesList } ">
<tr>
<td colspan=5 align="center">
<b>등록된 영화가 없습니다.</b>
</td>
</tr>
</c:when>
<c:when test ="${!empty moviesList  }">
<c:forEach var="mem" items="${moviesList }">
<tr align="center">
<td>${mem.id }</td>
<td>${mem.pwd }</td>
<td>${mem.name }</td>
<td>${mem.email }</td>
<td>${mem.joinDate }</td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</table>

</body>
</html>