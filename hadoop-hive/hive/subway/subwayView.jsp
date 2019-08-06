<%@page import="java.util.List"%>
<%@page import="vo.SubwayVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td, th, tr {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>지하철정보</h1>

	<%
		List<SubwayVO> list1 = (List<SubwayVO>) request.getAttribute("list1");

		if (list1 != null) {
	%>
	<table>
		<tr>
			<th>Line</th>
			<th>Time</th>
			<th>Ride</th>
			<th>Takeoff</th>
		</tr>
		<%
			for (SubwayVO vo : list1) {
		%>
		<tr>
			<td><%=vo.getLine()%></td>
			<td><%=vo.getTime()%></td>
			<td><%=vo.getRide()%></td>
			<td><%=vo.getTakeoff()%></td>
		</tr>
	<% 
	}
		%>
	</table>
	<%
		
		} else {
	%>
	${msg}
	<%
		}
	%>
</body>
</html>