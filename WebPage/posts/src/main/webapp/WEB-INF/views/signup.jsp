<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script type="text/javascript">
$(document).on("click",function(){
	$("#chkid").on("click", function(){
		var u_id=$('#u_id').val();
		if(u_id!=""){
		$.ajax({
			url:'/springposts/chkid?u_id='+u_id,
			type:'get',
			success:function(result){
				System.out.println(u_id);
				if(result==0){//0=사용가능 아이디 , 따라서 빈공간 =div해서 id값주기 .창에 반응글 보이기=ajax
					
					$('#chkresult').text("사용가능한 아이디 입니다").css("color","blue");
					$("#submit").attr("disabled",false); 
					//ajax후에 값 간직하고 submit시 전체 적으로 보내지도록 false=활성화 
				}else{
					$('#chkresult').text("사용 불가능한 아이디 입니다").css("color","red");
					$("#submit").attr("disabled",true)
					//submit 보내기전에 데이터가 전송 안되게=비활성화. 아이디 불가능하니까 안보내도록 
				}
			},
			error:function(){
				alert("에러입니다");
			}	
		});
		}
	});
});
</script>

</head>
<body>
<div>
<form method="post" action="/springposts/signup">

이름:<input type="text" name="u_name" required><br>

아이디:<input type="text" name="u_id" required>
<input type="button" id="chkid" value="중복체크">
<div id="chkresult"></div><br>

패스워드:<input type="password" name="passwd1" required>
패스워드 재확인:<input type="password" name="passwd2" required><br>

이메일:<input type="text" name="email" required>
<input type="button" id="chkemail" value="중복체크"><br>

생년월일:<input type="text" name="age" placeholder="6자리 입력" size="6" required>
<br>
성별:<input type="text" name="gender">
<br>
생성날짜:<input type="date" name="created_at">
<br>
<input type="submit" value="가입하기" id="submit">

<input type="button" value="취소" id="cancel">
</form>
</div>

<script>
$("#cancel").click(function(){
	location.href="/springposts/login";
});


</script>

</body>
</html>