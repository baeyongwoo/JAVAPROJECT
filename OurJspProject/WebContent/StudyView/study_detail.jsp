<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{text-align: center;
	  }
	#header{border-bottom: 5px solid purple;}
	#body{font-size: 20px;}
	#footer{}
textarea {
	margin: 50px;
	padding: 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=header>
		<h1>글제목 DB에서 가져오기</h1>
		
		<button onclick = window.history.back()>목록으로 돌아가기</button>
		</div> <!-- header / -->

	<div id=body>
	<textarea name="content" cols="200" rows="50">
DB에서 글 내용 가져오기
	</textarea>
	</div> <!-- body / -->
	
	<div id=footer>
		
	</div> <!-- footer / -->
</body>
</html>