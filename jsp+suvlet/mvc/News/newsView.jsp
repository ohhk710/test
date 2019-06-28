<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.NewsVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1, h2{
	color:hotpink;
}
*{
	text-align:center; 
}
body{
	background-repeat: no-repeat;
	background-image:linear-gradient(to bottom, #f2cbf2, white);
}
table{
	margin-left: auto; 
	margin-right: auto;
	border-collapse:collapse;
}
textarea{
	width:300px;
	height:200px;
	border: 1px solid mediumblue;
}
#writer,#title{
	width:200px;
	margin:5px;
	border: 1px solid mediumblue;
}
td {
	border: 2px dotted gold;
}
td:hover {
	font-weight: bold;
}
td:nth-child(2) {
	width: 200px;
}
tr:nth-child(1){
	background-color:wheat;
	color:hotpink;
}
#b{
	background-color: wheat;
    font-weight: bold;
    border: 1px dotted gold;
    color: mediumblue;
}
button{
	margin:3%;
}
</style>

</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<NewsVO> list = (ArrayList<NewsVO>) request.getAttribute("list");
		NewsVO vo1=(NewsVO)request.getAttribute("vo");
		//vo에 있는거 vo1넣어서 제목클릭시 수정할때 vo내용 보이기위해 변수재설정= 수정할꺼니까 vo랑 같은 명 안되고
	
		if (list != null) {
	%>
	<h1>뉴스 게시판</h1>
	
	<table>
	<tr>
		<td>번호</td> <td>제목</td> <td>작성자</td> <td>작성일</td> <td>조회수</td>
	</tr>
		<%
	for (NewsVO vo : list) { //리스트에 있는거 vo에 다 넣는 동안
		%>
		<tr>
			<td><%=vo.getId()%></td> 
			<td onclick="displayUpdateForm('<%=vo.getId() %>')"><%=vo.getTitle()%></td>
			<td onclick="listWr('<%=vo.getWriter() %>')"><%=vo.getWriter()%></td>
			<td><%=vo.getWritedate()%></td>
			<td><%=vo.getCnt()%></td>
		</tr>
	<%
		}
	%>
	</table>
	<%
		}
		
	if(request.getAttribute("msg")!=null){
	%>
		<script>
		alert('${msg}');
		</script>	
	<%
	}
	%>
	
	<form action="/mvc/news" method="GET">
	<input type="hidden" name="action" value="search">
	<select name="searchType">
		<option value="title">제목</option>
		
		<option value="writer">작성자</option>
		
		<option value="content">내용</option>
	</select>
	<input type="text" name="key">
	<input  type="submit" value="뉴스검색">
	</form>
	
	
	
	<!--뉴스작성 버튼 보이니까   만들고 누르면 창 띄우기=함수 만듦-->
	<button id='b' onclick="newshome();">뉴스홈</button>
	<button id='b' onclick="displayDiv(1);">뉴스작성</button>
	<script> //함수
		function displayDiv(type) { //div로 세칸 나뉨=작성자. 제목.content
			if (type == 1) {
				document.getElementById("write").style.display = "block"; 
				//document=html에서 write써인 것 띄움 =작성창
				document.getElementById("update").style.display = "none";
			} else if (type == 2) { //수정창을 확인시 사라지게 하려고
				document.getElementById("update").style.display = "none";
			} else if (type == 3) {//작성 취소시 창 사라짐
				document.getElementById("write").style.display = "none";
				//document.getElementById("update").style.display = "none";
			}
		}
		function displayUpdateForm(cv){ //제목선택시 get한것=servlet창 연결 = 해당 내용 창 띄우는 기능
			location.href='news?action=read&id='+cv; //a태그 대신해서 action과 id를 파라메터를 가지고 cv=id값실행
			}
		function deleteNews(cv){
			location.href='news?action=delete&id='+cv;	
		}
		function listWr(cv){
			location.href='news?action=listwriter&key='+cv;
		}
		function newshome(){
			location.href='news';
		}
	</script>
	
	<div id="write" style="display:none">
	<h2>뉴스 작성</h2>
		<form method="post" action="/mvc/news">
			<input type="hidden" name="action" value="insert"><br> <!--insert  -->
			<input id="writer" type="text" name="writer" placeholder="작성자명을 입력해주세요"><br>
			<input id="title" type="text" name="title" placeholder="제목을 입력해주세요"><br>
			<textarea id="content" name="content" placeholder="내용을 입력해주세요"></textarea><br>
			
			<input id='b' type="submit" value="저장"> 
			<input id='b' type="reset" value="재작성"> 
			<input id='b' onclick="displayDiv(3)" type="reset" value="취소">
		</form>
	</div>
	
	<% 
	if(vo1!=null){ //수정내용이 있으면 창 띄우는걸로 연결
	%>
	<div id="update">
		<form method="post" action="/mvc/news">
		<h2>뉴스 수정</h2>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="id" value="<%=vo1.getId()%>">
		<!--<FORM> 태그를 통해서 사용자가 입력한 내용 action=update&&newsid=xxx 가 함께 전달되게
			(hidden 타입의 <input> 태그 -->
			<input id="writer" type="text" name="writer" value='<%=vo1.getWriter() %>'><br>
			<input id="title" type="text" name="title" value='<%=vo1.getTitle() %>'><br>
			<textarea id="content" name="content"><%=vo1.getContent() %></textarea><br>
			
			<input id='b' onclick="displayDiv(2)" type="reset" value="확인">
			<input id='b' type="submit" value="수정">
			<input id='b' onclick="deleteNews('<%=vo1.getId()%>')" type="reset" value="삭제">
			<!--클릭시 발생하는 함수 만들기=deleteNews
			= id기준으로 id 변수에 전달된 id 값의 글을 delete메소드로 .명령으로 삭제 하고  -->			
		</form>
	</div>
	<%
	}
	%>

</body>
</html>