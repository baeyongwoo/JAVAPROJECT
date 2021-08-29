<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<style>
body{margin: 50px;}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<main>
    <div class="row">
        <div class="col-sm-12 text-center">
        
	<h1>${solve_user}님의 [${solve_code}]번 문제에 입력하신 답은 [${solve_solve}]입니다.</h1>
	
	<form action="/OurJspProject/check.use" method="post">
		<input type="hidden" name="code" value="${solve_code}">
		<input type="hidden" name="solve" value="${solve_solve}">
		<input type="hidden" name="suser" value="${solve_user}">
		<br/>
		<input class = "btn btn-primary" type="submit" value="정답확인">
		<br/><br/>
		<a class = "btn btn-warning" href="/OurJspProject/T_list.use">문제목록으로 돌아가기</a>	
	</form>
        
        </div>
    </div>
</main>
</div>
</body>
</html>