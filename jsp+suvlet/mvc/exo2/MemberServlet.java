package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		if(name=="")
			name="없음";
		if(number=="")
			number="없음";
		if(id=="")
			id="없음";
		if(pw=="")
			pw="없음";
		
		MemberVO vo=new MemberVO();//MemberVO라는 VO 객체에 저장하고 
		vo.setName(name);
		vo.setNumber(number);
		vo.setId(id);
		vo.setPw(pw);
		
		request.setAttribute("objreq", vo);//이 객체를 HttpServletRequest 객체에 저장한다.
		request.getRequestDispatcher("jspexam/memberView.jsp").//넘긴다.
        forward(request, response);
	
	}

}
