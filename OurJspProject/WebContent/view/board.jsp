<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
분류 : 
<select name="select">
    <option value="all">전체보기</option>
    <option value="notice">공지사항</option>
    <option value="question">질문</option>
    <option value="answer">답변</option>
    <option value="free">자유</option>
</select>
    
    <table border ="1">
    	<tr>
    		<td>글 제목</td>
    		<td><input type = "text"></td>
    	</tr>
    	<tr>
    		<td>글 내용</td>
    		<td><input type = "text"></td>
    	</tr>
    	<tr>
    		<td>글 작성자</td>
    		<td><input type = "text"></td>
    	</tr>    		
    </table>
   
</body>
</html>