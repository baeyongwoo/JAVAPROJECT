<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css">

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
		
div>h3{color: blue;
		font-size : 40px;}		
		
.left {
	 display: inline-block;
	 margin:10px;
	
}

.center {
	display: inline-block;
	margin:20px;
	
}

.right {
	display: inline-block;
	margin:10px;
	
}

</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div id="header" align="right">
		<a href="/OurJspProject/UserView/update_form.jsp"><button>회원정보수정</button></a>
		<a href="/OurJspProject/logout.use"><button>로그아웃</button></a>
			
	</div>
	<!-- head -->

	<div id="body" align="center">
	
		
		
		<div class="content">
		<div class="left" align="left">
			<c:set var="uname" value="${u_name}" scope="session"/>

			<h2>${uname} 환영합니다</h2>
			
			
			<form action ="/OurJspProject/q_list.use" method="post">
			<button class="btn btn-primary" name="subject" value="1">HTML 문제 풀러가기</button><br/><br/><br/>
			</form>
			
			
					
		</div>
		<div class="center" align="center">
		<p>
			<a href="/OurJspProject/getinfo.use">
				<button>내 정보 보기</button> </a> <br />
				<img src="../UserImage/mytier.jpg"/><br/>
		</p>
		<p>당신의 현재 TIER</p>
			<!-- 가능하다면 티어 db에서 인식해서 이미지 변경 -->
	</div>

		<div class="right" align="right">
		<h2>공부하러가기</h2>
		<p>
			<form action="/OurJspProject/StudyView/html_study.jsp" method="post">
			<button class="btn btn-primary" name="subject" value="1">HTML 공부 게시판</button><br/><br/><br/>
			</form>
		</div>

	</div>

	</div>	<!-- body -->
	<div id="footer">

			<c:if test="${uname eq ('test' or 'test1' or 'test2')}">
			
			<h3>문제 출제하기</h3>
				<p>	문제유형 선택 :</p> 
				<form action="/OurJspProject/questions.use" method="post">
				html <input type="radio" name ="subject" value="1">
				css <input type="radio" name ="subject" value="2">
				java <input type="radio" name ="subject" value="3">
				jsp <input type="radio" name ="subject" value="4"> <br/>

				<input type="text" name="question" placeholder="문제를 입력하세요"><br/>
				<input type="text" name="correct" placeholder="답을 입력하세요"><br/>
				<input type="submit" value="문제출제">
			</form>
			
			</c:if>
	
			
	</div>
</body>
</html>