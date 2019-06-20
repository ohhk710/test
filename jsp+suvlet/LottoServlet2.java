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
@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");
		//서블릿직접응답할때만=모델1, 여기서는 jsp=모델2 도 할줄알음
		
		
		int x = Integer.parseInt(request.getParameter("num"));
		int lot = (int)(Math.random() * 6 + 1);
		//jsp값 가지고오기
		String msg,src;
		
		
		System.out.println("전달된 값 : " + x + ", 추출된 값 :" + lot);
		if(x==lot) {
			msg="<h1 id='success'>로또 당첨!</h2>";
			src="http://blogfiles.naver.net/20121217_52/spgmbaceo_1355734071081MGyHJ_GIF/animated_gif_congratulations_images_glitter_61.gif";
		}else {
			msg="<h2>아쉽 아쉽 </h2><br>";
			src="http://blogfiles.naver.net/MjAxODAzMTlfMTI1/MDAxNTIxNDcwMzUzMDQ0.q1aKoCKsQH-Gmd5W_KKDkOjbb3EdmMjUhaoICI5_Vk0g.xGdhXUpimKt77yl1YKYNJjV25rQfqktmuMstIhg4OgQg.JPEG.whatsupray/%BC%AD%B8%A3%B4%CF%C0%CF%B1%E2%2C_%BC%AD%B8%A5%2C_thirty%2C_thirty_ray%2C_thirty_write%2C_%C0%A7%B7%CE.JPG";
		}
		
//		클라이언트에서 전달된 숫자와 동일하면 축하메시지와 이미지 정보를 '가지고', 
//		동일하지 않으면 위로 메시지와 이미지 정보를 '가지고' =리퀘스트에 객체를 담기
//		lottoResult.jsp 로 요청을 forward 한다

		//웹브라우저로(클라이언트)=jsp 출력요청 
		request.setAttribute("src", src);
		request.setAttribute("msg", msg);
		//jsp로 요청forward
		request.getRequestDispatcher("jspexam/lottoResult.jsp").forward(request,response);	  
	}
}
