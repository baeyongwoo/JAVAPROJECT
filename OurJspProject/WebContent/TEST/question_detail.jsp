<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/OurJspProject/UserView/login_success.jsp">
	<input type="button" value="목록으로"></a>
	<table border="1">
		<tr>
			<td>문제코드 : ${question.qcode}</td>
		</tr>
		<tr>
			<td>문제 : ${question.question}</td>
		</tr>
		<tr>
			<td>
				<!-- 문제 자세히 보고 답안 작성하러 가기 -->
				
				<form action="/OurJspProject/solve_form.use" method="post">
					<input type="hidden" name="qcode" value="${question.qcode}">
					<input type="submit" value="풀기">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>