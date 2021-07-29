<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원탈퇴</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/project/index.do";		    
			})
			$("#submit").on("click", function(){
				if($("#mem_pass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#mem_pass").focus();
					return false;
				}
				$.ajax({
					url : "/project/member/passChk.do",
					type : "POST",
					dataType : "json",
					data : $("#delForm").serializeArray(),
					success: function(data){
						
						if(data==0){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("회원탈퇴하시겠습니까?")){
								$("#delForm").submit();
							}
							
						}
					}
				})
				
			});
			
				
			
		})
	</script>
	<body>
		<section id="container">
			<form action="memberDelete.do" method="post" id="delForm">
				<div class="form-group has-feedback">
					<label class="control-label" for="mem_email">아이디</label>
					<input class="form-control" type="text" id="mem_email" name="mem_email" value="${member.mem_email}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="mem_pass">패스워드</label>
					<input class="form-control" type="password" id="mem_pass" name="mem_pass" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="mem_name">성명</label>
					<input class="form-control" type="text" id="mem_name" name="mem_name" value="${member.mem_name}" readonly="readonly"/>
				</div>
			</form>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="button" id="submit">회원탈퇴</button>
				<button class="cencle btn btn-danger" type="button">취소</button>
			</div>
			<div>
				<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
			</div>
		</section>
	</body>
</html>