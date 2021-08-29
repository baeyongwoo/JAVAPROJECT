<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<style>

</style>
<title>Insert title here</title>
</head>
<body>
	
	<button onclick="window.history.back()">문제목록</button></a>
	<div class = "row"></div>
	<table>
		<tr>
			<td>문제코드 : ${question.tcode}</td>
		</tr>
			
		<tr>
			<td>문제 : ${question.question}</td>
		</tr>
		<tr>
			<td>출제자 : ${question.s_user}</td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="${question.tcode eq 3001 }">
						<img src="/OurJspProject/TestImage/3001t.png" width="300" height="300">
					</c:when>
					<c:when test="${question.tcode eq 3002 }">
						<img src="/OurJspProject/TestImage/3002t.png" width="300" height="300">
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<!-- 문제 자세히 보고 답안 작성하러 가기 -->
				<form action="/OurJspProject/check.use" method="post">
					<input type="hidden" name="tcode" value="${question.tcode}">
					<input type="text" name="solve" placeholder="답을 입력하세요">
					<input type="hidden" name="suser" value="${u_id}">
					<input type="submit" value="풀기">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>