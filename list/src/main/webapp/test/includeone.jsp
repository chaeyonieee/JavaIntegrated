<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"%>
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
<h4>안녕하세요. 쇼핑몽 중심 JSP 시작입니다 !!!!</h4><br>
<jsp:include page ="total_image.jsp" flush="true">
<jsp:param name ="name" value ="듀크" />
<jsp:param name ="imgName" value="cat.jpg"/>
</jsp:include>


<h4>안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.!!!</h4>

</body>
