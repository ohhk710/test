package core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=utf-8");
		//html형식으로 받는다.

		//상품을 선택하여 요청할 때마다 이전에 선택했던 상품 정보가 유지되어야 한다.
		//클릭후 세션으로 정보유지
		HttpSession session=request.getSession();//세션객체 준비. 이미있으면 반환,없으면 생성
		PrintWriter out = response.getWriter();
		//반응에 답할때
		
		String pid=request.getParameter("pid");//여기서는 "id"의미
		
		if(pid.equals("remove")) { //또는 ==null
			session.invalidate();//세션 객체 자체를 삭제
			out.print("<h2>상품이 모두 삭제되었습니다</h2>");
			out.print("<a href='/sedu/html/productlog2.html'>상품 선택 화면</a>");
			out.close();
		}else {
			int id=Integer.parseInt(pid.substring(2));//00x스트링에서 x를 숫자로변환
			if(session.getAttribute("cnt")==null)//선택된 상품없음
				session.setAttribute("cnt", new int[10]);//상품수만큼 공간만들기
			int[] count=(int[])session.getAttribute("cnt");
			//(힌트, 10개의 원소를 가지는 int 타입의 배열을 생성하여 session 객체에 보관하고 선택된 상품의 개수를 저장한다.)
			//배열 위치별로 상품 아이디 순/ 대신 0부터 시작이라 맞춰야함
			count[id-1]++; //인덱스가 0부터라서 맞추려고 -1
			//상품이 누르면 count배열에 인덱스맞춰 그상품 갯수증가
			
			
			out.print("<h3>선택한 상품 리스트</h3>");
			out.print("--------------------");
			out.print("<ul>");
			for(int i=0;i<count.length;i++)
				if(count[i]!=0)
					out.print("<li>"+"p0"+(i+1)+"상품 : "+count[i]+"개 </li>");
					
			out.print("</ul>");
			
			//또는 url 변경되도 변화없으려고 referer
			out.print("<a href='"+request.getHeader("referer")+"'>상품 선택화면 </a>");
			out.print("<a href='/sedu/basket2?pid=remove'>상품비우기</a>");
			out.close();
		}
	}
}
