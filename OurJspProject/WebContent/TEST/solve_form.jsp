<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html>
            <head>
                <link
                    rel="stylesheet"
                    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
                    <meta charset="UTF-8">
                        <title>Insert title here</title>
                        <style>
                            .answer {
                                padding: 20px;
                                text-align: center;
                            }
                        </style>
                        <script></script>
                    </head>
                    <body>
                        <div class="container">
                            <div class="row">
                                <h1 class="text-primary text-center">문제풀기 페이지</h1>
                            </div>

                            <div class="row">
                                <form action="/OurJspProject/solve.use" method="post">
                                    <h4 class="text-warning text-center">
			<input type="text" name="qcode" value="${question.qcode}" readonly="readonly">
			</h4>
                                </div>
                                <div class="row">
                                    <h2 div="div" class="text-info text-center">문제내용</h2>
                                </div>
                                <br/>
                                <div class="row">
                                    <h3 div="div" class="text-info text-center"><input type="text" name="question" value="${question.question}" readonly="readonly"></h3>
                                    <div class="row">
                                        <div class="text-success text-center">정답을 입력해주세요</div>
                                    </div>
                                    <div class="row">
                                        <div class="text-succes text-center">
                                            <input class="answer form-control input-sm" type="text" name="answer"></div>
                                        </div>
                                        <br/>
                                        <div class="row text-center margin">
                                            <input class="btn btn-primary btn-lg" type="submit" value="정답 제출!"></form>
                                        </div>

                                    </body>
                                </html>