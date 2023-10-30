<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.navigation{
display:flex;
gap:40px;
margin-bottom:45px;

}
*{
margin:0;
padding:0;
box-sizing: border-box;
}


.flex{
display:flex;
flex-direction:column;
margin-bottom:48px;
}
p{
margin-bottom:48px;
}
.navigation{
display:flex;
gap:40px;
margin-bottom:45px;

}

.margin{
margin-bottom:40px;
}

.boxing{
border:1px solid black;
margin-bottom:28px;
}

a{
text-decoration:none;
color:black;
}
.check{
margin-bottom:25px;
}
</style>


<body>
<body>
<div class = "container">
<nav class="navigation">
<button>회원가입</button>
<button>로그인</button>
<button>주문 배송 조회</button>
<button>고객센터</button>
</nav>
<div class = "margin" >
<a href="#">전체 카테고리 |</a>
<a href="#">HOME |</a>
<a href="#">베스트 |</a>
<a href="#">신상품 |</a>
<a href="#">배송선택 |</a>
<a href="#">기프티콘 주문 |</a>
</div>
<p class="margin-login">로그인</p>

<div class="flex">
<label>아이디: <input type ="text" ${userId}></label>
<label>비밀번호: <input type ="password" ${pwd}></label>
<input type ="submit" value="로그인" />
</div>


<div  class="flex">
<label>이름: <input type ="text" ${userId}></label>
<label>주문번호: <input type ="password" ${order_number}></label>
<input type ="submit" value="비회원 주문 확인" />
</div>

<input type="checkbox"><label class="check">아이디 저장하기</label>


<div class="boxing">
<a href="#">아이디 찾기 |</a>
<a href="#">비밀번호 찾기 |</a>
<a href="#">회원가입 |</a>
</div>

<div class="boxing">


<a href="#">네이버 로그인 |</a>
<a href="#">카카오톡 로그인 |</a>
<a href="#">이메일 로그인 |</a>
</div>
</div>
</body>
</html>