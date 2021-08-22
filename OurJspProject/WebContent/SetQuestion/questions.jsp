<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/OurJspProject/questions.use" method="post">
		<%-- value값 나오게 해주세요 --%>
		<input type="text" name="qcode" value="1010 + 1" readonly="readonly">
		<input type="text" name="question" placeholder="문제의 답을 입력하세요">
		<input type="submit" value="정답입력">
	</form>
</body>
</html>