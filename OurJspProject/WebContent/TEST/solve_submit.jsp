<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${solve_user}님의 ${solve_code}입력하신 답은 ${solve_solve}입니다.</h1>
	<form action="/OurJspProject/check.use" method="post">
		<input type="hidden" name="code" value="${solve_code}">
		<input type="hidden" name="solve" value="${solve_solve}">
		<input type="submit" value="정답확인">
		<a href="/OurJspProject/T_list.use">돌아가기</a>	
	</form>
</body>
</html>