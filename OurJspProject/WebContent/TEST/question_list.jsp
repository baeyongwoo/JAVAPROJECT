<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<style>
	table {
	border: 2px dashed orange;
}
</style>
<meta charset="UTF-8">
<title>문제 리스트</title>
</head>
<body>


<div class="container">
<header>
    <div class="row">
        <h1 class = "text-center">문제 목록</h1>
    	<div class="col-sm-4 text-left">
    	<p><input type="button" value="메인페이지로" onclick="location.href='/OurJspProject/return.use'"></p>
    	<!-- <a href ="/OurJspProject/return.use"><button>메인페이지</button></a> -->
    	</div>
        <div class="col-sm-8 text-right">
		<a href="/OurJspProject/UserView/update_form.jsp"><button>회원정보수정</button></a>
		<a href="/OurJspProject/logout.use"><button>로그아웃</button></a>
        </div>
    </div>
</header>

<main>
    <div class="row">
        <div class="col-md-12 text-center">
        <br/>
		<table style="margin-left: auto; margin-right: auto;">
			<tr class ="text-center">
				<th class ="text-center" width="80px">문제번호</th>
				<th class ="text-center" width="800px">문제 미리보기</th>
			</tr>
		<c:forEach items="${t_l}" var="tlist">
			<tr>	
				<td class ="text-center"><a href="/OurJspProject/T_detail.use?tcode=${tlist.tcode}" >${tlist.tcode }</a></td>
				<td class ="text-center">${tlist.question}</td>
			</tr>
				</c:forEach>
		</table>        
        </div>
        <div class="col-xs-12"></div>
    </div>
</main>

<footer>
    <div class="row"></div>
</footer>		
			
		
	</div>
</body>
</html>