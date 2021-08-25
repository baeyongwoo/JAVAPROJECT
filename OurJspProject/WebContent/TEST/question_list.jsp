<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border: 5px solid #7fffd4;
	text-align: center
}

td {
	border: 1px solid;
	text-align: center
}

.user{padding:30px;}
</style>
<meta charset="UTF-8">
<title>HTML 문제 리스트</title>
</head>
<body>
	<div class="user" align="right">
		<a href="/OurJspProject/update.use"><button>회원정보수정</button></a>
		<a href="/OurJspProject/logout.use"><button>로그아웃</button></a>
	</div>

	<div align="center">
		<h1>HTML 문제 풀기</h1>
			
		<table>
			<tr>
				<th width="80px">문제번호</th>
				<th width="50px">
					<form action="/OurJspProject/q_list.use" method="post">
						<select name="select">
							<option value="all">html</option>
							<option value="notice">css</option>
							<option value="study">java</option>
							<option value="qna">jsp</option>
						</select>
					</form>
				</th>
				<th width="600px">문제 미리보기</th>
			</tr>
		<c:forEach items="${q_l}" var="qlist">
			<tr>	
				<td><a href="/OurJspProject/solve.use?qcode=${qlist.qcode }" >${qlist.qcode }</a></td>
				<td>타입</td>
				<td>${qlist.question}</td>
			</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>