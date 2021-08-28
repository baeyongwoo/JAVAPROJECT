<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#header{}
	#body{}
	#footer{}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "header">
	<a href = "http://localhost:8181/OurJspProject/UserView/login_success.jsp"><button>뒤로가기</button></a>
	</div>
	
	<div id = "body">
	<h1>${u_name }의 등급(${u_tier})</h1><!-- NAME과 등급은 DB에서 받아오기 -->
		<h2>공부해야 할 것</h2>
		<p>아이디 : ${u_id}</p><!-- DB에서 받아오기 -->
		<p>이름  : ${u_name}</p>
		<p>이메일 : ${u_email}</p>
		<p>흥미있는 과목 : ${u_subject}</p>
		<p>풀었던 코드 : ${u_qcode}</p>
		<p>포인트 : ${u_point}</p>
		<p>티어 : ${u_tier}</p>
	</div>
	
	<div id = "footer">
	
	</div>
	
</body>
</html>