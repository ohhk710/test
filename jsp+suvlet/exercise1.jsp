<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import= "java.util.Calendar"
import= "java.util.GregorianCalendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Calendar cal = new GregorianCalendar();
	
	String name = request.getParameter("name");
	char[] weeks = {'일', '월', '화', '수', '목', '금', '토'};
	
	
	out.print("<h2>"+name+"님 반갑습니다. 오늘은 "
			+weeks[cal.get(Calendar.DAY_OF_WEEK)-1]+"요일 입니다.</h2>");

	%>
	
	<%-- 
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("E", Locale.KOREAN);
	
	<h2><%=name %>님 반가워요.. 오늘은 <%=format.format(date) %>요일입니다!!</h2> 
	
	<%
	String name = request.getParameter("name");
	out.print("<h2>"+ name + "님 반가워요.. 오늘은 " +getWeek()+"요일입니다!!</h2>");
	%>
	--%>
</body>
</html>