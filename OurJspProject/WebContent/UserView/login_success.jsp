<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css">

<style>
body{margin: 50px;}
header{border-bottom:10px solid red; }
.name{height: 50px;}
.question{border-top: 10px solid yellow; padding: 20px;}
.rmain{height: 100%; margin: 20px;
		position: relative;}
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>


<div class="container">
	<header>
    <div class="row">
        <div class="name col-md-8 text-left">
        	<div class="logintime text-primary">${u_ids}님 로그인 시간 : ${login}</div>
        </div>
        <div class="name col-md-4 text-right">
        <a href="/OurJspProject/UserView/update_form.jsp"><button>회원정보수정</button></a>
		<a href="/OurJspProject/logout.use"><button>로그아웃</button></a>
        </div>
    </div>
    </header>
    <main>
    <div class="rmain row" >
       
        <div class="col-md-3 text-center">
        	<br/><br/><br/><br/><br/><br/>
        <form action ="/OurJspProject/T_list.use" method="post">
			<h2>테스트하러가기</h2>
			<button class="btn btn-primary" name="subject">문제리스트 가기</button><br/><br/><br/>
		</form>
        </div>
        
        <div class="con2 col-md-6 text-center">
        <h1>${u_name }의 등급 (${u_tier})</h1><!-- NAME과 등급은 DB에서 받아오기 -->
		<h2>공부해야 할 것</h2>
		<p>아이디 : ${u_id}</p><!-- DB에서 받아오기 -->
		<p>이름  : ${u_name}</p>
		<p>이메일 : ${u_email}</p>
		<p>흥미있는 과목 : ${u_subject}</p>
		<p>풀었던 코드 : ${u_qcode}</p>
		<p>포인트 : ${u_point}</p>
		<p>티어 : ${u_tier}</p>
        </div>
        
        <div class="col-md-3 text-center align-self-center">
        <br/><br/><br/><br/><br/><br/>
        <h2>공부하러가기</h2>
			<form action="/OurJspProject/StudyView/html_study.jsp" method="post">
			<button class="btn btn-primary" name="subject" value="1">HTML 공부 게시판</button><br/><br/><br/>
			</form>
        </div>
    </div>
    
    <c:if test="${u_ids eq 'test'}">
    <div class = "question row">
    	<div class = "col-md-12 text-center">
    		<h3 class = "text-primary">문제 출제하기</h3>
				<div>문제유형 선택</div> 
				<form action="/OurJspProject/Test.use" method="post">
				
				html<input type="radio" name ="subject" value="1">&nbsp;&nbsp;
				css<input type="radio" name ="subject" value="2">&nbsp;&nbsp;
				java<input type="radio" name ="subject" value="3">&nbsp;&nbsp;
				jsp<input type="radio" name ="subject" value="4">&nbsp;&nbsp;
				<br/>

				<input class = "form-control text-center" type="text" name="question" placeholder="문제를 입력하세요"><br/><br/>
				<input class = "form-control text-center" type="text" name="correct" placeholder="답을 입력하세요"><br/>
				<input type="submit" value="문제출제">
			</form>
    	</div>
    </div>
    </c:if>
    
    </main>
    <footer>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6"></div>
        <div class="col-md-3"></div>
    </div>
    </footer>
</div>
</body>
</html>