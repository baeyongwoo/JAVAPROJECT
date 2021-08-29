<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<meta charset="UTF-8">
<style>
body{margin: 20px;}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<header>
	<div class="row text-left">
	<button onclick="window.history.back()">문제목록</button>
	</div>
	</header>
	<div class = "row text-center">
	<h1 class="text-primary">문제</h1>
	<div>${question.question}</div>

	<h3 class="text-warning">문제코드</h3>
	<div>${question.tcode}</div>
		
		
	<div>출제자 : ${question.s_user}</div>
	</div>
		
				<c:choose>
					<c:when test="${question.tcode eq 3001 }">
						<img src="/OurJspProject/TestImage/3001t.png" width="300" height="300">
					</c:when>
					<c:when test="${question.tcode eq 3002 }">
						<img src="/OurJspProject/TestImage/3002t.png" width="300" height="300">
					</c:when>
				</c:choose>
		
		
				<!-- 문제 자세히 보고 답안 작성하러 가기 -->
				<div class="row text-center">
				<form action="/OurJspProject/submit.use" method="post">
					<input type="hidden" name="tcode" value="${question.tcode}">
					<input type="text" name="solve" placeholder="답을 입력하세요">
					<input type="hidden" name="suser" value="${u_id}">
					<input class="btn-success" type="submit" value="답안제출">
				</form>
				</div>

	</div>
</body>
</html>