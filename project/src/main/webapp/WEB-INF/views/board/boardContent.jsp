<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function boardDel(){
	var form = document.getElementById('boardDelForm');
		form.submit();
	}
function Back(){
	window.history.back();
}
</script>
</head>
<body>
<h1>게시물 내용</h1>
<div>작성자 : <input type="text" value="${vo.b_writer}" readonly="readonly">
<span style="margin-left: 300px">작성날짜 : ${vo.b_writedate}
조회수 : ${vo.b_readnum}
</span>
</div>
<table>
	<tr>
	<td>제목 : <input type="text" value="${vo.b_subject}" readonly="readonly" style="width: 738px"></td>
	</tr>
	<tr>
		<td colspan="1"><textarea readonly="readonly" cols="110" rows="20">${vo.b_content}</textarea></td>
	</tr>
</table>
<div id="button" style="margin-left: 700px">
<form id="boardDelForm" action="boardDelete.do" method="get">
<input type="hidden" name="b_idx" value="${b_idx}">
<input type="button" value="삭제하기" onclick="boardDel()">
<input type="button" value="수정하기" onclick="location.href='boardUpdate.do?b_idx=${b_idx}'">
<input type="button" value="뒤로가기" onclick="Back();"></td>
</form>
</div>
</body>
</html>