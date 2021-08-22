<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="OurJspProject/question.use">
		<input type="text" name="qcode" value="${q_code}" readonly="readonly">
		<input type="text" name="question" placeholder="문제를 입력하세요">
		<input type="submit" value="제출">
	</form>
</body>
</html>