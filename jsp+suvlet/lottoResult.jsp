<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h2 {
	color: Green;
	font-weight: bold;
}

img {
	width: 400px;
	height: 400px;
}

* {
	text-align: center;
}

a {
	color: red;
	font-weight: bold
}
</style>
<body>

	<%
		String msg = (String) request.getAttribute("msg");
		String src = (String) request.getAttribute("src");
		String fail = (String) request.getAttribute("fail");

		out.print(msg);
		out.print("<img src='" + src + "'>");

		if (fail != null) {
			out.print(fail);
		}
	%>
	<!-- 당첨되지 않았을 때는 링크도 출력(=jsp에서) 해야 하는데 어떻게 해결할지 방법을 생각해보고
적용한다 -->


</body>
</html>