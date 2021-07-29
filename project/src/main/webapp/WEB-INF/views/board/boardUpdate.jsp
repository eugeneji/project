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
function Back(){
	window.history.back();
}
</script>
</head>
<body>
<form id="boardUpdateForm" action="boardUpdate.do" method="post">
<input type="hidden" value="${vo.b_idx}" name="b_idx">
<h1>게시물 내용</h1>
<div>작성자: <input type="text" name="b_writer" value="${vo.b_writer}"></div>
<div>제목: <input type="text" name="b_subject" value="${vo.b_subject}" style="width: 745px"></div>
<div><textarea cols="110" rows="20" name="b_content">${vo.b_content}</textarea></div>
<div id="update" style="margin-left: 700px">
<input type="submit" value="수정완료">
<input type="button" value="뒤로가기" onclick="Back();">
</div>
</form>
</body>
</html>