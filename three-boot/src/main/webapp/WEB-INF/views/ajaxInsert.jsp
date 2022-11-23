<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>Ajax Home</h1>
<form action="/boards/insert" method="post">
   title : <input type="text" name="title" id = "title" /><br>
   content : <textarea name="content" id="content"></textarea><br>
   writer : <input type="text" name="writer" id="writer" /><br><br>
   <button type="submit">등록</button>
</form><br>
</body>
</html>