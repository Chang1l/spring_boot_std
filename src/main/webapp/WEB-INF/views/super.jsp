<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
</head>
<body class="container">
<h2>super 페이지 입니다.</h2>
   <form action="logout" method="post" class='card'>
      <a href='/super'>super 유저 페이지로 이동합니다</a>
      <a href='/normal'>normal 유저 페이지로 이동합니다</a>
      <a href='/member'>member 유저 페이지로 이동합니다</a>
      <div>로그인 성공하면 보이는 멤버(member) 페이지 입니다.</div>
      <input type="submit" value="로그아웃">
   </form>
</body>
</html>