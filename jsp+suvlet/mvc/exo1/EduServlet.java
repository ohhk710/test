package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EduServlet
 */
@WebServlet("/edu")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String add;
		int grade=Integer.parseInt(request.getParameter("grade"));
		
		if(grade>=90)
			add="jspexam/gradeA.jsp";
		else if(grade>=80)
			add="jspexam/gradeB.jsp";
		else if(grade>=70)
			add="jspexam/gradeC.jsp";
		else
			add="jspexam/gradeD.jsp";
		
		request.getRequestDispatcher(add).forward(request,response);//하나로쓰기
	}

}
