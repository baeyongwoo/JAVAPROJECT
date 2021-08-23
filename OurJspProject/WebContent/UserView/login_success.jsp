<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	padding: 0
}

* {
	margin: 0
}
body{background: white;
	text-align: center;}

#header { margin:10px
	
}

#body {
}

#footer {clear: both;
	
}

a{text-decoration: none;
 line-height: 60px;
 font-size: 20px;
 font: bolder;}
a:hover{color:green;}
a:active{color:red;}

.content{margin:50px;

		}

div>h2{color: maroon;
		font-size: 40px}		
		
.left {
	 display: inline-block;
	 margin:30px;
	
}

.center {
	display: inline-block;
	margin:20px;
	
}

.right {
	display: inline-block;
	margin:30px;
	
}
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div id="header" align="right">
		<a href="/OurJspProject/update.use"><button>회원정보수정</button></a> <a
			href="/OurJspProject/logout.use"><button>로그아웃</button></a>
			${u_name}
	</div>
	<!-- head -->

	<div id="body" align="center">
	
		<c:set var="uid" value="${u_name}"/> <!-- Attribute 값을 가져오면 JSTL로 출력이 가능함. -->
		
		<div class="content">
		<div class="left" align="left">
			<c:choose>
				<c:when test="${uid eq '테스트1'}"> <!-- 유저 실력을 판가름할 변수로 출력할 메뉴 설정 현재는 테스트를 위해 test라는 이름을 가진 사람만 출제메뉴 생성 -->
			<h2>"${uid}" 실력자시군요</h2>
			<p>
				<a href=""></a>
				<a href="http://localhost:8181/OurJspProject/SetQuestion/questions.jsp">HTML 문제출제</a><br />
				<a href="http://localhost:8181/OurJspProject/SetQuestion/questions.jsp">JAVA 문제출제	</a><br />
				<a href="http://localhost:8181/OurJspProject/SetQuestion/questions.jsp">JSP 문제출제</a><br />
				<a href="http://localhost:8181/OurJspProject/SetQuestion/questions.jsp">CSS 문제출제</a>
			</p>
			</c:when>
				<c:when test="${uid eq 'test2'}">
			<h2>"${u_id}" 실력을 보여주세요</h2>
			<p>
				<a href="http://localhost:8181/OurJspProject/TestView/HTML_test.jsp">HTML 테스트</a><br /> <a
				href="http://localhost:8181/OurJspProject/TestView/java_test.jsp">JAVA
				테스트</a><br /> <a
				href="http://localhost:8181/OurJspProject/TestView/jsp_test.jsp">JSP
				테스트</a><br /> <a
				href="http://localhost:8181/OurJspProject/TestView/css_test.jsp">CSS
				테스트</a>
			</p>
			</c:when>
			<c:otherwise>
			로그인 해주셔야 메뉴가 보여요
			</c:otherwise>
			</c:choose>
			
			
		</div>
	
		<div class="center" align="center">
		<p>
			<a href="http://localhost:8181/OurJspProject/UserView/getinfo_form.jsp">
				<button>내 정보 보기</button> </a> <br />
				<img src="../UserImage/mytier.jpg"/><br/>
		</p>
		<p>당신의 현재 TIER</p>
			<!-- 가능하다면 티어 db에서 인식해서 이미지 변경 -->
	</div>

		<div class="right" align="right">
		<h2>실력 보충하기</h2>
		<p>
			<a
				href="http://localhost:8181/OurJspProject/StudyView/html_study.jsp">HTML
				공부하기</a><br /> <a
				href="http://localhost:8181/OurJspProject/StudyView/java_study.jsp">JAVA
				공부하기</a><br /> <a
				href="http://localhost:8181/OurJspProject/StudyView/jsp_study.jsp">JSP
				공부하기</a><br /> <a
				href="http://localhost:8181/OurJspProject/StudyView/css_study.jsp">CSS
				공부하기</a>
		</p>
		</div>

	</div>

	</div>	<!-- body -->
	<div id="footer"></div>
</body>
</html>