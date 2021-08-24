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
	<h1>${u_name }의 등급(JAVA 마스터)</h1><!-- NAME과 등급은 DB에서 받아오기 -->
		<h2>공부해야 할 것</h2>
		<p>HTML, JSP, CSS</p><!-- DB에서 받아오기 -->
	</div>
	
	<div id = "footer">
	
	</div>
	
</body>
</html>