<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body{
			align-content : center;
			font: 12px "고딕", Gothic, bolder;
			color:teal;
			background:url("./notice.jpg") no-repeat;
			background-position: center;
			background-size: 120%;
			background-color: #f5f1b1;
			}
		h1{
			text-shadow:3px 3px 0px #bdbdbd;
				}
		
		ul{	
			list-style: none;
			padding-left: 0px;
			font-size: 35px;
			text-shadow:3px 3px 0px #bdbdbd;
			}
		
		.user{
			border-top:5px dashed;
			border-bottom:5px dashed;
			width:200px;
			height:50px;
			padding-top: 25px;
			}
	button{border-top-right-radius: 10px;
			border-bottom-left-radius: 10px;
			background-color: rgb(0,0,0,0);
			color:blue;
			}
			
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	
		<h1>공지사항</h1>
			<ul>
				<li>욕설 절대 금지</li>
				<li>혼자서 도배하지 말아주세요</li>
				<li>다른사람의 의견을 존중합시다</li>
			</ul>
		<div class="user">
		<a href="http://localhost:8181/OurJspProject/UserView/join_form.jsp"><button>회원가입</button></a>&nbsp;&nbsp;
		<a href="http://localhost:8181/OurJspProject/UserView/login_form.jsp"><button>로그인</button></a>
		</div>
	</div>
</body>
</html>