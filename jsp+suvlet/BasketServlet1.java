package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pid = request.getParameter("pid");// pid쿼리 추출 하나씩 받으니까
		String path = "C:/logist";
		/*
		 * C:/logtest 폴더가 존재하지 않으면 생성하며 C:/logtest 폴더에 mylog.txt 를 만들고
		 */ File folder = new File("C:/logist");
		if (!folder.isDirectory()) {
			folder.mkdirs();
		}

		/*
		 * 또는 if(!folder.exists()) { // 폴더가 없을경우 try { folder.mkdir(); } catch(Exception
		 * e) { e.printStackTrace(); } }
		 */

		/*
		 * 만들고 다음 형식으로 요청 시마다 201808191050 p002
		 */
		Date today = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyymmddHHmm");
		String dateText = time.format(today) + " " + pid;

		// 행 단위로 저장한다.
		// FileWriter fw = new FileWriter("C:/logtest/mylog.txt",true);
		// 또는
		String txtPath = path + "/mylog.txt";
		File txt = new File(txtPath);
		FileWriter fw = new FileWriter(txt, true);// 파일 쓰기 객체(덮어쓰기)
		// 기존 파일의 내용에 이어서 쓰려면 true, 기존 내용을 없애고 새로 쓰려면 false
		fw.write(dateText + "\r\n"); // 쓰기
		fw.flush();
		fw.close();

		/*
		 * JSON 형식으로 전달된 상품 정보를 응답한다. { “pid”: “p003”} 이런 형식으로.
		 */ 
		response.setContentType("application/json; charset=utf-8");
		// json타입으로 받음 // 응답 형식 text/json도 가능

		PrintWriter out = response.getWriter();
		String jsonStr = "{\"pid\":\""+pid+"\"}"; // json표현때 무조건 더블인용부호 =문자열 하지만 이중이라 안쪽에 \붙임
		
		// 제이슨형식으로 추출// 앞 pid 문자열이고 뒤pid는 아이디 받는 변수

		out.print(jsonStr);
		out.close();
	}
}
