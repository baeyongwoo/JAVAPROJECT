<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제를 제출해주세요</title>
</head>
<body>
<c:set var="uname" value="${u_name}" scope="session"/>
<c:set var="qcode" value="${q_code}" scope="application"/>
	<h1>"${uname }" 님은 문제를 출제하실수 있습니다.</h1>
	<form action="/OurJspProject/questions.use" method="post">
		<input type="hidden" name="qcode" value="+1" readonly="readonly">
		<input type="text" name="question" placeholder="문제를 입력하세요">
		<input type="submit" value="정답입력">

	</form>
</body>
</html>