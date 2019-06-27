<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	border-bottom: 1px dotted green;
}

tr:hover {
	background-color: pink;
	font-weight: bold;
}

td:nth-child(3) {
	width: 300pxl;
}
div {
	display: none
}
</style>
</head>
<body>

	<c:if test="${ !empty list }">
	
	<h2>Meeting Schedule List(JSPL)</h2>
	<hr>
	
	<table>
	
	<c:forEach var="vo" items="${ list }">		
		<tr>
			<td>${ vo.id }</td>
			<td class='${ vo.id }'>${ vo.name }</td>
			<td class='${ vo.id }'>${ vo.title }</td>
			<td class='${ vo.id }'>${ vo.meetingDate }</td>
			<td><a href='/mvc/meeting?action=delete&id=${ vo.id }'><img src="/mvc/images/delete.png" width="30"></a></td>
			<td>
				<img onclick="displayUpdateForm('${ vo.id }')"
				src="/mvc/images/edit.png" width="30">
			</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${!empty msg }">
		<script>
		alert('${msg}');
		</script>
	</c:if>
	
	<hr>
	<button onclick="displayDiv(1);">미팅 정보작성</button>
	<button onclick="displayDiv(2);">미팅 정보 검색</button>
	<script>
		function displayDiv(type) {
			if (type == 1) {
				document.getElementById("write").style.display = "block";
				document.getElementById("search").style.display = "none";
			} else if (type == 2) {
				document.getElementById("write").style.display = "none";
				document.getElementById("search").style.display = "block";
			} else if (type == 3) {
				document.getElementById("write").style.display = "none";
				document.getElementById("search").style.display = "none";
			}
		}
		function displayUpdateForm(cv){
			var doms = document.getElementsByClassName(cv)
			document.getElementById("write").style.display='block';
			document.getElementById("name").value=doms[0].textContent;
			document.getElementById("title").value=doms[1].textContent;
			document.getElementById("datetime").value=meeting_dt;
			document.getElementById("divT").textContent="미팅정보 수정";
			document.querySelector("#write [type=submit]").value="수정";
			document.querySelector("#write [type=hidden]").value=cv;
			//document.getElementById("action").value = "update";
			
			var str= doms[2].textContent;
			var ary= str.split(/\D+/g);
			var meeting_dt=ary[0]+"-"+ary[1]+"-"+ary[2]+"T"+ary[3]+":"+ary[4];
			document.getElementById("meetingDateTime").value = meeting_dt;
		}
	</script>
	
	<div id="write" style="display: none">
		<h1 id="divT">미팅잡기</h1>
		<hr>
		<form action="/mvc/meeting" method="post">
			<input type="hidden" name="action" value="insert">
			미팅 이름<input type="text" name="name" id="name"><br> 
			미팅 목적<input type="text" name="title" id="title"><br> 
			시간<input type="datetime-local" name="datetime" id="datetime"><br>
			<input type="submit" value="제출">
			<input type="reset" value="재작성">
			<a href='${ header.referer }'>방명록 홈 화면으로 가기</a>
		</form>
	</div>
	
	<div id="search" style="display:none">
		<form method="get" action='/mvc/meeting'>
			검색어:<input type="search" name='keyword'>
			<input type="submit" value="검색">
			<hr>
			<a href='${ header.referer }'>방명록 홈 화면으로 가기</a>
		</form>
	</div>
	
</body>
</html>