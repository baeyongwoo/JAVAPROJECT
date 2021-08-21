<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {padding: 0}

#header {
	height: 50px;
	}

#body {
	}

#footer {
	
	}	
	
.mainborder{border:1px solid black;}
.left{}
.cneter{}
.right{}
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div id=header align="right">
		<a href="/OurJspProject/update.use"><button>회원정보수정</button></a> <a
			href="/OurJspProject/logout.use"><button>로그아웃</button></a>
	</div> <!-- head -->

	<div id=body>
		<div class=mainborder align="left" >
			<div class=left>
				<h2>실력을 보여주세요</h2>
					<p>
					<a href="http://localhost:8181/OurJspProject/TestView/html_test.jsp">HTML
					테스트</a><br /> <a
					href="http://localhost:8181/OurJspProject/TestView/java_test.jsp">JAVA
					테스트</a><br /> <a
					href="http://localhost:8181/OurJspProject/TestView/jsp_test.jsp">JSP
					테스트</a><br /> <a
					href="http://localhost:8181/OurJspProject/TestView/css_test.jsp">CSS
					테스트</a>
					</p>
			</div>
	
		<div class=center align="center">
			<p>
			<a href="http://localhost:8181/OurJspProject/UserView/getinfo_form.jsp">
				<button>내 정보 보기</button></a> 
			<br /> <img src="../UserImage/mytier.jpg">
			<!-- 가능하다면 티어 db에서 인식해서 이미지 변경 -->
			<p>
		</div>
		
		<div class=right align="right">
			<h2>실력 보충하기</h2>
			<p>
				<a	href="http://localhost:8181/OurJspProject/StudyView/html_study.jsp">HTML
					공부하기</a><br /> <a
					href="http://localhost:8181/OurJspProject/StudyView/java_study.jsp">JAVA
					공부하기</a><br /> <a
					href="http://localhost:8181/OurJspProject/StudyView/jsp_study.jsp">JSP
					공부하기</a><br /> <a
					href="http://localhost:8181/OurJspProject/StudyView/css_study.jsp">CSS
					공부하기</a>
				</p>
		</div>
		</div><!-- mainborder -->
	</div> <!-- body -->
	<div id=footer>
	</div>
</body>
</html>