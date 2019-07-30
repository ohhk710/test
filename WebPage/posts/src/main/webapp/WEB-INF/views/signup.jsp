<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script type="text/javascript">
	$(function() {
		$("#chkid").click( function() {
					var u_id = $("#u_id").val();
					console.log(u_id);
					$.ajax({
						url : '/springposts/chkid?u_id=' + u_id,
						type : 'get',
						success : function(result) {
							console.log("1=중복 0은 가능 " + result);
							if (result == 0) {//0=사용가능 아이디 , 따라서 빈공간 =div해서 id값주기 .창에 반응글 보이기=ajax
								$('#chkresult').text("사용가능한 아이디 입니다").css(
										"color", "blue");
								$("#submit").attr("disabled", false);
								//ajax후에 값 간직하고 submit시 전체 적으로 보내지도록 false=활성화 
							} else {
								$('#chkresult').text("사용 불가능한 아이디 입니다").css(
										"color", "red");
								$("#submit").attr("disabled", true);
								//submit 보내기전에 데이터가 전송 안되게=비활성화. 아이디 불가능하니까 안보내도록 
							}
						},
						error : function() {
							alert("에러입니다");
						}
					});
				});
	});
	
	$(function(){
		$("#chkemail").click(function(){
			var email=$("#email").val();
			$.ajax({
				url:'/springposts/chkemail?email='+email,
			    type:"get",
			    success : function(result){
			    	console.log(email);
			    	if(result==0){
			    		$("#emailresult").text("사용가능한 email입니다.").css("color","blue");
			    		
			    	}else{
			    		$("#emailresult").text("사용 불가능한 email입니다").css("color","red");
			    	}
			    },
			    error:function(){
			    	alert("에러입니다");
			    }
			});
		});
		
	});
	
	function zipSearch(){
		
	}
	
	
</script>
<script>
    function passwdconfirm(){
    	if($('#passwd1').val()==$('#passwd2').val()){
    		$('#passwdresult').text("비밀번호가 일치합니다").css("color","blue");
    	}else{
    		$('#passwdresult').text("비밀번호가 다릅니다.").css("color","red");
    	}
    	
    }

	$("#cancel").click(function() {
		location.href = "/springposts/login";
	});
	
</script>

</head>
<body>
	<div>
		<form method="post" action="/springposts/signup">

			이름:<input type="text" name="u_name" required>
			<br> 
			아이디:<input
				type="text" name="u_id" id="u_id" required>
			<button id="chkid">중복체크</button>
			<div id="chkresult"></div>

			패스워드:<input type="password" name="passwd1" id= "passwd1" required>
			패스워드 재확인:<input type="password" name="passwd2" id="passwd2" onkeyup="passwdconfirm()" required>
			<div id="passwdresult"></div>
			<br>
			이메일:<input type="text" name="email" id="email" required>
			<button id="chkemail">중복체크</button>
			<div id="emailresult"></div>
			<br> 
			생년월일:<input type="text" name="age" placeholder="6자리 입력" size="6" required> 
				<br> 
			성별:<input type="text" name="gender"> 
				<br> 
			생성날짜:<input type="date" name="created_at"> 
				<br> 
			주소: <input name="zipcode" size="5" readonly>
				<button onclick="zipSearch()">우편번호찾기</button>
				<div id="zipresult"></div>
				
			<input type="submit" value="가입하기" id="submit">
			<button id="cancel" onClick="location.href='login'">취소</button>
		</form>
	</div>



</body>
</html>