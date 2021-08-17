<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

table {
	border: 5px solid #7fffd4;
	text-align: center
}
td {
	border: 1px solid ;
	text-align: center
}
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div align="center">
	<h1>게시판</h1>
		<table>
			<tr>
				<th width="50px">번호</th>
				<th width="50px">
					<form action="#" method="post">
						<select name="select">
							<option value="all">전체보기</option>
							<option value="notice">공지사항</option>
							<option value="trip">여행</option>
							<option value="study">공부</option>
							<option value="meeting">미팅</option>
						</select>
					</form>
				</th>
				<th width="600px">글 제목</th>
				<th width="100px">작성자</th>
			</tr>
			<tr>
				<td>${num }0</td>
				<td>${type}여행</td>
				<td><a href="#">${title} 임시제목</a></td>
				<td>${writer}홍길동</td>
		</table>
	</div>
</body>
</html>