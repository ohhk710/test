<%@page import="model.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{
		text-decoration:none;
		padding:5px;
		background:linear-gradient(#ffff99,#99cc00);
	}
</style>
</head>
<body>
<%
	ProductVO product = (ProductVO)session.getAttribute("product");
%>
<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<ul>

<li>선택된 사과의 개수 : <%=product.getAppleNb() %></li>
<li>선택된 사과의 개수 : <%=product.getBananaNb() %></li>
<li>선택된 사과의 개수 : <%=product.getHalabongNb() %></li>

<%-- <jsp:useBean id="member" property="name" name="memeber class="model.vo.MemberVO" scope="request"/>

<li>선택된 사과의 개수 : <jsp:setProperty property="appleNb" name="product"/>
<li>선택된 바나나의 개수 : <jsp:setProperty property="bananaNb" name="product"/>
<li>선택된 한라봉의 개수 : <jsp:setProperty property="halabonNb" name="product"/>
</ul>
<hr>

<h1>선택된 상품 정보는 다음과 같습니다.</h1>
<hr>
<ul>

<jsp:useBean id="member" property="name" name="member class="model.vo.MemberVO" scope="request"/>

<li>선택된 사과의 개수 :${sessionScope.product.appleNb}/> <!--또는~scope 생략가능  -->
<li>선택된 바나나의 개수 : ${sessionScope.product.bananaNb}/>
<li>선택된 한라봉의 개수 : ${sessionScope.product.halabongNb}/>
</ul>

 --%>
<a href="/mvc/htmlexam/product.html">상품 선택 화면</a>
</body>
</html>