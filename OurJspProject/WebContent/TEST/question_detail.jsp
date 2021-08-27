<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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