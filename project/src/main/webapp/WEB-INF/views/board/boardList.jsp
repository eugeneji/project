<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function Content(b_idx){
		location.href='boardContent.do?b_idx='+b_idx;
	}
	function show(cp){
		location.href='boardList.do?cp='+cp;
	}
</script>
</head>
<body>
<form action="boardWrite.do" method="get">
<h1>게시판</h1>
<table>
	<thead>
	<tr>
		<th>글 번호</th>
		<th>제 목</th>
		<th>작성자</th>
		<th>작성 날짜</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${empty list}">
		<tr>
			<td colspan="4" align="center">등록된 게시물이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="list" items="${list}">
	<tr>
		<td align="center">${list.b_idx}</td>
		<c:url var="ContentUrl" value="boardContent.do">
			<c:param name="b_idx">${list.b_idx}</c:param>
		</c:url>
		<td align="center"><a href="javascript:Content(${list.b_idx})">${list.b_subject}</a></td>
		<td align="center">${list.b_writer}</td>
		<td align="center">${list.b_writedate}</td>
		<td align="center">${list.b_readnum}</td>
	</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
		<td><input type="submit" value="글 작성하기"></td>
	</tr>
	</tfoot>
</table>
  <div class="search">
    <select name="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="s"<c:out value="${scri.searchType eq 's' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="sc"<c:out value="${scri.searchType eq 'sc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button id="searchBtn" type="button">검색</button>
    <script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "boardList.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
  </div>
</form>
<div>
  <ul>
    <c:if test="${pageMaker.prev}">
    	<li><a href="boardList.do${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
    </c:if> 
    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li><a href="boardList.do${pageMaker.makeSearch(idx)}">${idx}</a></li>
    </c:forEach>
    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li><a href="boardList.do${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  </ul>
</div>
</body>
</html>