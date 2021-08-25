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

	<form action = "/OurJspProject/answer.use" method="post">
	<c:forEach items="${q_l}" var="qlist"> 
	<p><div>문제코드 : ${qlist.qcode }</div>
	<p><div>문제내용 : ${qlist.question }</div>
	</c:forEach>
	<input type="text" name="subject" value="1000"></p>
	<div>정답을 입력해주세요</div><input type ="text" name="answer">
	<input type="hidden" name="name" value="${name}">
	<input type="submit" value="정답 제출!">
	
	</form>

</body>
</html>