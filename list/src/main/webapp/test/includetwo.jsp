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
<h4>안녕하세요. 쇼핑몰 중심 JSP 시작입니다 !!!!</h4><br>
<br>
<jsp:include page ="total_image.jsp" flush="true">
<jsp:param name ="name" value ="듀크2" />
<jsp:param name ="imgName" value="dog.jpg" />
</jsp:include>
<br>
안녕하세요. 쇼핑몰중심 JSP 끝 부분입니다!!
</body>
</html>