<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<div>
		<form action="/springposts/login" method="post">
			아이디: <input type="text" name="u_id"> 
			비밀번호 <input type="password" name="passwd"> 
			<input type="submit" value="로그인">
			
			<a href="/springposts/signup">회원가입</a>
			<a href="/springposts/forgot">아이디or비밀번호 찾기</a>
		</form>
	</div>

</body>
</html>