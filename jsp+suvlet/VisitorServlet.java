package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public VisitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//doGet /doPost 꼭 쓰기
		//출력하는것이 html형식이고. 글자들은 utf-8로 출력할것이다 = out에 대한것
		request.setCharacterEncoding("utf-8");
		//html에서 쓴것에 글자 형식  
		
		String name=request.getParameter("name"); //요청한것 이름으로 받기
		String txt=request.getParameter("txt"); //요청한것 이름으로 받기

		PrintWriter out=response.getWriter(); //지금 아래쪽에 반응으로 쓸것을 출력하기
		request.setCharacterEncoding("UTF-8"); //그것은 utf-8로 작성되어있다
		
		Date today= new Date();
		DateFormat format =DateFormat.getDateInstance(DateFormat.FULL); //깔끔하게 다 출력하는 메소드
		
		out.print("<h2>"+name+"님이"+format.format(today)+"에 남긴 글입니다 </h2>");
		out.print("<hr>");
		out.print("내용"+txt+"<br>");
		out.print("<a href ='/sedu/html/visitorForm.html'>입력화면</a>"); //링크걸기
		
		
	}


}
