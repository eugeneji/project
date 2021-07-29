<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardWrite.do" method="POST">
<h1>글 작성하기</h1>
<table>
<tr>
	<td><input type="text" name="b_subject"></td>
	<td><input type="text" name="b_writer"></td>
</tr>
<tr>
	<td><textarea name="b_content" cols="50" rows="30" required="required" placeholder="내용을 입력하여 주십시오."></textarea></td>
</tr>
<tr>
	<td><input type="submit" value="작성완료"></td>
</tr>
</table>
</form>
</body>
</html>