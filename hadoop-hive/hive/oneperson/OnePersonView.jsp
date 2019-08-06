<%@page import="java.util.List"%>
<%@page import="vo.OnePersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>1인 가구 정보</h1>
	<button onclick="clickbtn(1)">1인가구가 많은순으로 전체 출력</button>
	<br>
	<button onclick="clickbtn(2)">구별 1인 가구 명수 출력</button>
	<br>
	<button onclick="clickbtn(3)">1인가구가 제일 많은 동의 구 이름과 동이름 출력</button>
	<br>
	<button onclick="clickbtn(4)">1인가구가 제일 많은 구 이름 출력</button>
	<br>

	<form action="/springedu/one" method="GET">
		점검하려는 구이름 입력 : <input type="text" name="gu"> <input
			type="submit" id="guSearch" value="검색">
	</form>


	<c:choose>
		<c:when test="${ list1 !=null }">
				<tr>
					<td>${data.gu }</td>
					<td>${data.dong }</td>
					<td>${data.personnb }</td>
				</tr>
			<c:forEach var="data" items="${list1}">
			</c:forEach>
		</c:when>
		<c:when test="${ list2 !=null }">
				<h2>결과출력</h2>
				<hr>
				<tr>
					<th>GU</th>
					<th>PERSON NUMBER</th>
				</tr>
			<c:forEach var="data" items="${list2}">
				<tr>
					<td>${data.gu }</td>
					<td>${data.personnb }</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:when test="${ list3 !=null }">
				<h2>결과출력</h2>
				<hr>
				<tr>
					<th>GU</th>
					<th>DONG</th>
				</tr>
			<c:forEach var="data" items="${list3}">
				<tr>
					<td>${data.gu }</td>
					<td>${data.dong }</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:when test="${ list4 !=null }">
			<h2>결과출력</h2>
			<hr>
			<tr>
				<th>GU</th>
			</tr>
			<c:forEach var="data" items="${list4}">
				<tr>
					<td>${data.gu }</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>

	<script type="text/javascript">
		function clickbtn(nb) {
			location.href = "/springedu/one?nb=" + nb;
		}
	</script>
</body>
</html>