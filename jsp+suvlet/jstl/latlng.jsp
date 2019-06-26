<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ pageContext.request.method =='GET' }">
			<!--test조건식 에대한 else= otherwise  -->
			<h2>위치,경도 알고싶은 주소 입력</h2>
			<hr>
			<form method="post" action="/sedu/jspexam/latlng.jsp">
				지역:<input type="text" name="local" required> <input
					type="submit" value="확인">
			</form>
		</c:when>

		<c:otherwise>
			<!--한글 주소로 받을려면 utf-8설정  -->
			<%
				request.setCharacterEncoding("UTF-8");
			%>
			<h2>${param.local }위치</h2>
			<hr>
			<!--import: 특정 URL의 결과를 읽어와 현재 위치에 삽입하거나, EL변수에 저장할 때 사용
				url: URL 생성하는 기능/ 논리적인 경로(실제 경로x)
				redirect:지정한 페이지로 리다이렉트시켜주는 기능제
			  -->
			<c:catch var="ex">
				<!--CATCH=TRY  -->
				<!--방법1 
					<c:import var="xmldata"
					url="https://maps.googleapis.com/maps/api/geocode/xml?address=${param.location}&language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE">
				  -->
				<c:url var="url"
					value="https://maps.googleapis.com/maps/api/geocode/xml?address=language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE" />
				<c:param name="urlparam" value="${param.local }"></c:param>
				<c:import var="xmldata" url="${ url }" charEncoding="UTF-8" />
				<!--파싱하기 =찾기=dom만들어서= 하나의 틀 / xdata라는 변수명주고 그안에서 찾기=여기서는 url값   -->
				<!--x는 xml  -->
				<x:parse xml="${ xmldata }" varDom="xdata" />
				<x:if select="$xdata//status = 'ok'">
					<!--select 조건에 맞는 태그가 존재하는지   여기서는 status/ 아래는 끝정보-->
				주소 : <x:out select="$xdata//formatted_address" />
					<br>
				위도 : <x:out select="$xdata//location/lat" />
					<br>
				경도 : <x:out select="$xdata//location/lng" />
					<br>

					<c:set var="outFlag" value="true" />
					<c:if test="${ empty outFlag }">
						<h3>${param.local }의정보가존재하지 않아요...</h3>
					</c:if>
				</x:if>
				<x:if select="$xdata//status !=ok">
					<h3>${ param.addr }의정보가 존재하지 않아요...</h3>
				</x:if>
			</c:catch>
			<!--catch끝하고 예외= 전체ex에 대한 -->
			<c:if test="${ !empty ex }">
				<h3>오류 발생</h3>
			</c:if>
			<hr>
			<a href="/sedu/jspexam/latlng.jsp">입력 화면으로</a>
		</c:otherwise>
	</c:choose>

</body>
</html>