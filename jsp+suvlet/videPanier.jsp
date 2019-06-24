<%@ page contentType="application/json; charset=UTF-8"%>

<!--장바구니 비우는 요청은 Ajax 로 처리한후 결과는 경고창에 출력한다  -->
<%
session.removeAttribute("product");
%>
{"msg":"장바구니가 비워졌습니다."}
