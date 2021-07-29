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
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/login";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#mem_id").focus();
					return false;
				}
				if($("#mem_pass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#mem_name").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
			});
			
				
			
		})
	</script>
	<body>
		<section id="container">
			<form action="memberJoin.do" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">이메일</label>
					<input class="form-control" type="email" id="mem_email" name="mem_email" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">패스워드</label>
					<input class="form-control" type="password" id="mem_pass" name="mem_pass" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">성명</label>
					<input class="form-control" type="text" id="mem_name" name="mem_name" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">성별</label>
					<input class="form-control" type="text" id="mem_sex" name="mem_sex" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">주소</label>
					<input class="form-control" type="text" id="mem_addr" name="mem_addr" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">상세주소</label>
					<input class="form-control" type="text" id="mem_addr_detail" name="mem_addr_detail" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">전화번호</label>
					<input class="form-control" type="text" id="mem_tel" name="mem_tel" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">회원등급</label>
					<input class="form-control" type="text" id="mem_grade" name="mem_grade" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="userName">이미지</label>
					<input class="form-control" type="text" id="mem_img" name="mem_img" />
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>
		
	</body>
	
</html>