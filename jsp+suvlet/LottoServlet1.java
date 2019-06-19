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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		int x = Integer.parseInt(request.getParameter("num"));
		int lot = (int)(Math.random() * 6 + 1);

		System.out.println("전달된 값 : " + x + ", 추출된 값 :" + lot);
		if (x == lot) {
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("jspexam/fail.jsp");
			rd.forward(request, response);
		}
	}

}
