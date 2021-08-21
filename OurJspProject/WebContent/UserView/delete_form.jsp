<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
body{background: url("../UserImage/delete_form.jpg");
	background-position:center 120px;
	background-size:10%;}
h1{color:red;
	font-size:50px;
	text-shadow: 0 0 30px blue;}
h2{color:white;
	text-shadow: 0 0 20px aqua; }
input{padding: 10px;}
a{color: green;
		text-shadow: 0 0 20px yellow;}
	</style>
<meta charset="UTF-8">
<title>회원탈퇴 하실건가요? ㅠㅠ</title>
</head>
<body>
	<div align="center">
	<h1>뭐라고???? 회원탈퇴?!?!????!??!?!?</h1>
	<h2>아진짜형누나언니오빠삼촌이모왜그래그냥공부같이하자쫌!!!!!!!</h2>
	<p class="a">그래도 갈거면 아래 입력하던가...</p>
	<form action ="/OurJspProject/delete.use" method="post">
	<input type="text" name="id" placeholder="${user.id}" readonly="readonly"/><br/><br/>
	<input type="password" name="id" placeholder="비밀번호쓰면 우린 끝난거야"><br/><br/>
	<input type="submit" value="회원탈퇴">
	</form>
	</div>
</body>
</html>