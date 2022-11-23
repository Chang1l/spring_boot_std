<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
   crossorigin="anonymous"></script>
     <style>
   .fBtn{margin:0 20px; border-radius:5px!important;}
   .input-group{margin:0 auto; width:350px!important;}
   </style>
   
</head>
<body class="container">
	<h2>로그인</h2>
	<form action="login" method="post" class="card">
	<input type="text" name="username" placeholder="username"> 
	<input type="text" name="password" placeholder="password">
	<div class="input-group p-3">
	<input type="submit" class="btn btn-primary form-control fbtn" value="로그인">
	<input type="button" class="btn btn-primary form-control fbtn" value="회원가입" onclick="javascript:location.href='newMember';"> 
	</div>
	</form>
</body>
</html>