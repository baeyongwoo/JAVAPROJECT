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

	<form action = "/OurJspProject/submit.use" method="post">
	<!-- 
	<div>문제코드 : ${question.qcode }</div>
	<div>문제내용 : ${question.question }</div>
	 -->
	<!-- 예를 들면 3번 문제에 이미지가 필요하면 첨부하는 로직 -->
	<input type="text" name="qcode" value="${question.qcode}" readonly="readonly">
	<input type="text" name="question" value="${question.question}" readonly="readonly">
	
	<div>정답을 입력해주세요</div>
	
	<input type ="text" name="answer">

	<input type="submit" value="정답 제출!">
	</form>

</body>
</html>