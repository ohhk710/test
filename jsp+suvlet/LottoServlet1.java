package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LottoServlet1
 */
@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");//서블릿직접응답할때만, 여기서는 jsp도 할줄알음

		int x = Integer.parseInt(request.getParameter("num"));
		int lot = (int)(Math.random() * 6 + 1);
		//String url;//forward가 반복되니까
		System.out.println("전달된 값 : " + x + ", 추출된 값 :" + lot);
		if (x == lot) {
			//url="jspexam/success.jsp";
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/success.jsp");
			rd.forward(request, response);
		} else {
			//"jspexam/fail.jsp"
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/fail.jsp");
			rd.forward(request, response);
		}
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("url");
		 * rd.forward(request, response);
		 * 또는
		 * request.getRequestDispatcher(url).forward(request,response);
		 * 
		 */
	}

}
