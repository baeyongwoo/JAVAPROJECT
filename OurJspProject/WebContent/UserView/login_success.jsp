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
        	<br/><br/><br/><br/><br/>
        <form action ="/OurJspProject/T_list.use" method="post">
			<h2>실력검증</h2>
			<button class="btn btn-primary" name="subject">문제리스트</button><br/><br/><br/>
		</form>
        </div>
        
        <div class="con2 col-md-6 text-center">
        <h1>${u_name }의 TIER</h1>
       
        <c:choose>
        <c:when test="${u_tier eq '7'}">
        <div class = "text-primary"><h2>챌린저</h2></div>
        <img class="text-center" width="400px" src="https://i.imgur.com/bI3V2Du.png">
        </c:when>
       
        <c:when test="${u_tier eq '6'}">
        <div class = "text-primary"><h2>마스터</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/nVHE2E8.jpg">
        </c:when>
   
        <c:when test="${u_tier eq '5'}">
        <div class = "text-primary"><h2>다이아</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/c2Lrej0.png">
        </c:when>
   
        <c:when test="${u_tier eq '4'}">
        <div class = "text-primary"><h2>플레티넘</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/hvlkheQ.png">
        </c:when>
   
        <c:when test="${u_tier eq '3'}">
        <div class = "text-primary"><h2>골드</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/oXcTcLm.png">
        </c:when>
   
        <c:when test="${u_tier eq '2'}">
        <div class = "text-primary"><h2>실버</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/OpdJgBX.png">
        </c:when>
   
        <c:when test="${u_tier eq '1'}">
        <div class = "text-primary"><h2>브론즈</h2></div>
        <img class="text-center" width="300px" src="https://i.imgur.com/pAJmQTv.jpg">
        </c:when>

        <c:when test="${u_tier eq '0'}">
        <div class = "text-primary"><h2>심해</h2></div>
        <img class="text-center" width="300px" src="https://imgur.com/QxHXxVp">
        </c:when>
        </c:choose>
        
        
		
		<div>이름  : ${u_name}</div>
		<div>이메일 : ${u_email}</div>
		<div>흥미있는 과목 : ${u_subject}</div>
		<div>풀었던 코드 : ${u_qcode}</div>
		<div>포인트 : ${u_point}</div>
        </div>
        
        <div class="col-md-3 text-center align-self-center">
        <br/><br/><br/><br/><br/>
        <h2>소통공간</h2>
			<form action="/OurJspProject/StudyView/html_study.jsp" method="post">
			<button class="btn btn-primary" name="subject" value="1">게시판</button><br/><br/><br/>
			</form>
        </div>
    </div>
    
    <c:if test="${u_ids eq ('test' or 'admin')}">
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