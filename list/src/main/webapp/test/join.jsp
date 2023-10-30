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
.container{
width:1200px;
margin: 0 auto;

}
.container{
border: 1px solid black;
}
.margin{
margin-bottom:40px;
}
.flex{
display:flex;
flex-direction:column;
margin-bottom:48px;s
}
</style>
<body>
<div class = "container">
<nav class="navigation">
<button>회원가입</button>
<button>로그인</button>
<button>주문 배송 조회</button>
<button>고객센터</button>
</nav>
<div class = "margin">
<a href="#">전체 카테고리</a>
<a href="#">HOME</a>
<a href="#">베스트</a>
<a href="#">신상품</a>
<a href="#">배송선택</a>
<a href="#">기프티콘 주문</a>
</div>
<div class = "margin">
<a href="#">약관동의</a>
<a href="#">본인인증 /정보 입력</a>
<a href="#">가입완료</a>

</div>
<div class="flex">
<label>아이디: <input type ="text" name="${userId}"> </label>
<label>비밀번호: <input type ="password" name=${pwd}></label>
<label>비밀번호 확인: <input type ="text" name= ${pwdcheck}></label>
<label>이름: <input type ="text" name = ${username}></label>
<label>이메일: <input type ="email" name = ${useremail}></label>
<label>이름: <input type ="text" name = ${telphone}></label>
<label>우편번호 찾기<input type ="text" name = ${address}></label>
<label>상세주소입력: <input type ="text" name = ${more_detail}></label>
</div>

<div>
<input type ="submit" value="이전단계" />
<input type ="submit" value="가입하기" />
</div>


</div>
</body>
</html>