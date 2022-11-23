<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>Ajax Home</h1>
	<form>
	 <input type="text" name="keyword" id="keyword" placeholder="제목이나 저자를 입력해주세여(일부입력 가능)" size="50">
	 <button type="button" id="searchBtn">Search</button>
	</form>
	<h3>목록 보기</h3>
	<div id="dataBox">
	<c:forEach items="${boardList }" var="board">
	번호: ${board.boardNo }, 제목: ${board.title }, 저자: ${board.writer },
	출판일: ${board.regDate }<br>
	</c:forEach>
	
	</div>

<script>

$(document).ready(function(){
$("#searchBtn").on("click", function(){
    let keyword =  $("#keyword").val();      
    $.get("/boards/search/"+keyword,function(data){
  	  console.log(data);
  	   $("#dataBox").empty();
          if(data!= '') {
              $.each(data,function(i,v){
                  $("#dataBox").append("번호: "+v.boardNo+"/ 제목: "+v.title+"/ 저자: "+v.writer+"/ 출판일: "
       		   +v.regDate.substr(0,10)+"/ 내용: "+v.content+"<br>");
              });
           }
    });
 });
});
</script>


</body>
</html>