<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date" />

	<form action = "/OurJspProject/ansewer.use" method="post">
	<p>문제가 띄워질 자리</p> <!-- JSTL로 랜덤출력 처리하기 -->
	<div>정답을 입력해주세요</div><input type ="text" name="answer">
	<input type="hidden" name="name" value="${name}">
	<input type="submit" value="정답 제출!">
	
	</form>

</body>
</html>