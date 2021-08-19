<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		.delete{color:red;}
		body{text-align: center;}
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
		<form action="/OurJspProject/update.use" method="post">
		<input type="text" name ="id" placeholder="${user.id }" readonly="readonly"/><br/>
		<input type="password" name ="pw" placeholder="변경할 비밀번호를 입력해주세요"/><br/>
		<input type="email" name ="email" placeholder="${user.email }"/>
		<input type="hidden" name ="name" value="${user.name }"/>
		<input type="hidden" name ="age" value="${user.age }"/>
		<input type="hidden" name ="gender" value="${user.gender }"/><br/><br/>
		<input type="submit">
		<input type="reset"><br/><br/>
		<a href="/OurJspProject/login.use"><button>게시판으로 돌아가기</button></a><br/><br/>
		<a href="/OurJspProject/delete.use"><button class="delete">회원탈퇴</button></a>
		</form>
</body>
</html>