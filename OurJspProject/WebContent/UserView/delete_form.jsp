<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
body{background: url("../UserImage/delete_form.jpg") no-repeat;
	background-position:center 120px;
	background-size:50%;}
h1{color:red;
	font-size:50px;}
	</style>
<meta charset="UTF-8">
<title>회원탈퇴 하실건가요? ㅠㅠ</title>
</head>
<body>
	<div align="center">
	<h1>회원탈퇴</h1>
	<form action ="/OurJspProject/delete.use" method="post">
	<input type="text" name="id" placeholder="${user.id}" readonly="readonly"/><br/><br/>
	<input type="password" name="id" placeholder="비밀번호를 입력해주세요"><br/><br/>
	<input type="submit" value="회원탈퇴">
	</form>
	</div>
</body>
</html>