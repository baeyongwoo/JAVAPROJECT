<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
#header{position: relative;
		width:1000px;height:300px; }
#body{width:1000px;}
#footer{}
table {
	border: 5px solid #7fffd4;
	text-align: center
}

td {
	border: 1px solid;
	text-align: center
}
.left{float: left;
	margin-right: 50px;}
.center{float: left;}
.right{float: left;
		text-align: right;
		margin-left: 50px}
.user{padding:30px;}
.border{border:1px solid black;}
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div id="header" align="right">
		<a href="/OurJspProject/update.use"><button>회원정보수정</button></a>
		<a href="/OurJspProject/logout.use"><button>로그아웃</button></a>
	</div>
	
	<div id="body">
	<div class = left>실력을 보여주세요
		<p class = "boder">
		<a href = "http://localhost:8181/OurJspProject/UserView/html_test.jsp">HTML 테스트</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/java_test.jsp">JAVA 테스트</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/jsp_test.jsp">JSP 테스트</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/string_test.jsp">STRING 테스트</a>
		</p>		
	</div>
	<div class = center align="center">
		<a href="http://localhost:8181/OurJspProject/UserView/getinfo_form.jsp">
		현재 당신의 코딩 티어입니다
		</a>
		<br/>
			<img src="../UserImage/mytier.jpg"> <!-- 가능하다면 티어 db에서 인식해서 이미지 변경 -->
		<br/><br/>
		</div>
	<div class = right>실력 보충하기
		<p class = "boder">
		<a href = "http://localhost:8181/OurJspProject/UserView/html_test.jsp">HTML 공부하기</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/java_test.jsp">JAVA 공부하기</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/jsp_test.jsp">JSP 공부하기</a><br/>
		<a href = "http://localhost:8181/OurJspProject/UserView/string_test.jsp">STRING 공부하기</a>
		</p>		
	</div>
	
	<div id="footer">
	
	</div>

	</div>
</body>
</html>