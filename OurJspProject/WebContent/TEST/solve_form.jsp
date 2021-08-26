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

	<form action = "/OurJspProject/answer.use" method="post">
	
	
	
	<div>문제코드 : ${qcodeVO.qcode }</div>
	<div>문제내용 : ${qcodeVO.question }</div>
	

	<div>정답을 입력해주세요</div><input type ="text" name="answer">
	<input type="submit" value="정답 제출!">
	</form>

</body>
</html>