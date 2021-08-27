<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<style>
	body{background: url("../UserImage/select.png") no-repeat #fe4e81;
	background-position:center;
	background-size:100%;
	text-align: center;}
		.delete{color:red;}
		input{padding: 10px;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
		<form action="/OurJspProject/update.use" method="post">
		<input type="text" name ="uid" value="${u_id}" readonly="readonly" size="30"/><br/>
		<input type="password" name ="upw" placeholder="변경할 비밀번호" size="30"/><br/>
		<input type="email" name ="uemail" value="${u_email}" placeholder="변경할 이메일" size="30"/><br/><br/>
		<input type="submit" value="수정완료">
		<input type="reset"><br/><br/>
		</form>
		<a href="http://localhost:8181/OurJspProject/UserView/login_success.jsp"><button>게시판으로 돌아가기</button></a><br/><br/>
		<a href="http://localhost:8181/OurJspProject/UserView/delete_form.jsp"><button class="delete">회원탈퇴</button></a>
</body>
</html>