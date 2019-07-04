package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//파라미터 가져오기
		String pid=request.getParameter("pid");
		
		//세션객체 생성또는 반환=()/(true) 있으면 준비 없으면 자동으로 생성=getSession
		HttpSession session=request.getSession();

		ProductVO product=(ProductVO)session.getAttribute("product");
		//보관되어 있지 않다면 ProductVO 객체를 새로이 생성하고 선택된 상품 정보를 1 개 
		//누적시킨 후에 세션 객체에 보관한다.
		if(product==null) {
			product =new ProductVO();
		}//이미 보관되어 있는 경우에는 이 객체를 추출하여 선택된 상품 정보를 1개 누적 시킨다.
		if(pid.equals("p001"))
			product.setAppleNb(1);
		else if(pid.equals("p002"))
			product.setBananaNb(1);
		else if(pid.equals("p003"))
			product.setHalabonNb(1);
		//요청을 jspexam/productView.jsp 넘겨서 대신 응답하게 한다
		session.setAttribute("product",product); //(key,value)
		request.getRequestDispatcher("jspexam/productView.jsp").forward(request, response);
	
	}

}
