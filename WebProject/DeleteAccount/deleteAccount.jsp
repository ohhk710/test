<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.SignupVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	/* function gotodelete(){
	 location.href='/deleteAccount'
	 } */
</script>

</head>
<body>
	<%
		/* SignupVO vo = (SignupVO) session.getAttribute("vo"); */
		SignupVO vo = new SignupVO();
		vo.setU_id(3);
		vo.setU_name("2");
		vo.setPasswd("1234");
		vo.setEmail("ohg");
		vo.setAge(40);
		vo.setCreated_at("19/07/10");
		vo.setPrivilege("user");
		vo.setGender("woman");
	%>
	<input type="hidden" name="id" value="<%=vo.getU_id()%>">
	<table>
		<tr>
			<td>이름 :</td>
			<td><%=vo.getU_name()%></td>
		</tr>
		<tr>
			<td>성별 :</td>
			<td><%=vo.getGender()%></td>
		</tr>
		<tr>
			<td>나이 :</td>
			<td><%=vo.getAge()%></td>
		</tr>
		<tr>
			<td>아이디 :</td>
			<td><%=vo.getU_id()%></td>
		</tr>
	</table>

	<form action="/springposts/passwd" method="post">
		<input type="hidden" name="u_id" value="<%=vo.getU_id()%>">
		<table>
			<tr>
				<td>신규 비밀번호 :</td>
				<td><input type="password" name="passwd" /></td>
				<td>신규 비밀번호 확인:</td>
				<td><input type="password"></td>
				<td><input type="submit" value="변경하기" /></td>
			</tr>
		</table>
	</form>

	<form action="/springposts/email" method="post">
		<input type="hidden" name="u_id" value="<%=vo.getU_id()%>">
		<table>
			<tr>
				<td>현재 이메일 :</td>
				<td><%=vo.getEmail()%></td>
				<td>변경 이메일 :<input type="email" name ="email"/>
				</td>
				<td><input type="submit" value="변경하기" /></td>
			</tr>
		</table>
	</form>

	<button id='b' onclick="displayDiv(1)">회원탈퇴하기</button>

<script>
	function displayDiv(type){
		if(type==1){
			document.getElementById("delete").style.display="block";
		}else if(type==2){
			document.getElementById("delete").style.display="none";
		}
	}
</script>

<div id="delete" style="display:none">
	<form action="/springposts/deleteAccount" method="post" onsubmit="return confirm ('정말 탈퇴하시겠습니까?')">
	<input type="hidden" name="u_id" value="<%=vo.getU_id()%>">
		<label class="legend">비밀번호</label> <input name="passwd" type="password"> 
		<input type="submit" value="회원탈퇴"><input type="reset" onclick="displayDiv(2)" value="취소하기">
	</form>
</div>

</body>
</html>