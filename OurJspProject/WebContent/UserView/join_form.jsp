<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>
<head>
<style>
body {
	align-content: center;
	background: url(../UserImage/join.jpg) no-repeat;
	background-size: 900px;
	background-position: center;
	background-color: #FFD71F;}
	
input{padding: 10px;
border: 1px solid #58D3F7;}

p{}
	
}
</style>
<script>
	
</script>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<div align="center">
	<h1>WELCOME TO OUR JSP</h1>
		<form action="/OurJspProject/join.use" method="post">
			<input type="text" name="uid" placeholder="아이디를 입력해주세요" size="30"><br />
			<input type="password" name="upw" placeholder="패스워드를 입력해주세요" size="30"><br />
			<input type="text" name="uname" placeholder="이름을 입력해주세요" size="30"><br />
			<input type="email" name="uemail" placeholder="이메일을 입력해주세요" size="30"><br />
			
			<p>공부 경험 :  <input type="text" name="subject" placeholder="ex)html, css, java"></p>
			
			<input type="submit" value="회원가입하기">
			<input type="reset">
		</form>
	</div>
</body>
</html>