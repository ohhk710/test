<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전달된 내용</h2>
	<hr>
	<ul>
		<%
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String age = request.getParameter("age");
			String sexe = request.getParameter("sexe");
			String[] hobby = request.getParameterValues("hobby");
			String color = request.getParameter("color");
			String[] food = request.getParameterValues("food");
			String textarea = request.getParameter("texta");
			String secret1 = request.getParameter("비밀1");
			String secret2 = request.getParameter("비밀2");


			out.print("<ul>");
			out.print("<li>이름 :" + name + "</li>");

			out.print("<li>이름 :" + password + "</li>");

			out.print("<li>이름 :" + age + "</li>");

			out.print("<li>이름 :" + sexe + "</li>");

			out.print("<li>취미 :");
			if (hobby == null) {
				out.print("없음");
			} else {
				for (int i = 0; i < hobby.length; i++) {
					out.print(hobby[i]);
					if (i != hobby.length - 1) {
						out.print(", ");
					}
				}
			}
			out.print("</li> <li>좋아하는 색 :");
			if (color == null) {
				out.print("없음");
			} else {
				out.print(color);
			}

			out.print("</li> <li>좋아하는 음식 :");
			if (food == null) {
				out.print("없음");
			} else {
				for (int i = 0; i < food.length; i++) {
					out.print(food[i]);
					if (i != food.length - 1) {
						out.print(", ");
					}
				}
			}
			out.print("</li><li>의견 : " + textarea + "</li>");

			out.print("<li>비밀1 : " + secret1 + "</li>");

			out.print("<li>비밀2 : " + secret2 + "</li>");

			out.print("</ul>");

			out.print("<hr><a href ='/sedu/html/queryForm.html'>입력화면</a>");
		%>

	</ul>

</body>
</html>