<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<div>
	<ul>
	<li>
		<c:if test="${login != null}"><a href="/project/member/memberLogout.do">로그아웃</a></c:if>
		<c:if test="${login == null}"><a href="/project/member/memberLogin.do">로그인</a></c:if>
	</li>
	<li>
		<c:if test="${login != null}">
			<p>${sessionScope.login.mem_email}님 안녕하세요.</p>
			<a href="/project/member/memberDelete.do">회원탈퇴</a>
		</c:if>
	</li>
</ul>
</div>