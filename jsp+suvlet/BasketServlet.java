package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		
		String pid=request.getParameter("pid");//하나씩 받으니까
		
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		out.print("선택한 상품 : "+pid);

		out.print("<hr><a href ='/sedu/html/productlog.html'>상품 선택화면으로 가기 </a>");
		out.close();
		

	
	}

}
