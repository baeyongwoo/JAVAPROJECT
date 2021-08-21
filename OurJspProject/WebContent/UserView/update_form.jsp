<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<style>
		.delete{color:red;}
		body{text-align: center;}
		input{padding: 10px;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
		<form action="/OurJspProject/update.use" method="post">
		<input type="text" name ="id" value="${u_id }" readonly="readonly" size="30"/><br/>
		<input type="password" name ="pw" placeholder="변경할 비밀번호" size="30"/><br/>
		<input type="email" name ="email" value="${u_email }" size="30"/><br/><br/>
		<input type="hidden" name ="name" value="${u_name }" size="30"/>
		<input type="submit" value="수정완료">
		<input type="reset"><br/><br/>
		</form>
		<a href="http://localhost:8181/OurJspProject/UserView/login_success.jsp"><button>게시판으로 돌아가기</button></a><br/><br/>
		<a href="http://localhost:8181/OurJspProject/UserView/delete_form.jsp"><button class="delete">회원탈퇴</button></a>
</body>
</html>