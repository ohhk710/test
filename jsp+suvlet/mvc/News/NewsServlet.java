package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.MeetingVO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 뉴스의 전체 리스트 출력  요청시 쿼리문자열 없음
		 * 제목 선택 시 : 해당 뉴스 id 로 해당 뉴스 내용 출력 
		 * 삭제 버튼 클릭시 : 뉴스 삭제
		 */	
		//action="서버측프로그램주소"= form태그 된거 받기/ 지정한 모든 아이디 받기
		String tmpId = request.getParameter("id"); //Parameter= String값만 따라서 Attribute 는 전체
		String action = request.getParameter("action");
		NewsDAO dao=new NewsDAO();//사용할 NewsDAO 객체 생성
		String key=request.getParameter("key");
		String searchType=request.getParameter("searchType");
		List<NewsVO> list = null;
		if(action!=null ) {
			//요청시 문자열 없으면 if절 안만들어도됨 
			//문자열로 받은 id int로 
			if(action.equals("read")&&tmpId!=null) {
				//제목선택 시 : 해당 뉴스 id 로 해당 뉴스 내용 출력
				//요청시 문자열 action=read & newsid xxx
				NewsVO vo=dao.listOne(Integer.parseInt(tmpId)); //dao패키지에 있는 listOne 클라스 이용 id 받아 하나씩 출력기능 을 vo에 넣음
				request.setAttribute("vo", vo); //받은 vo객체를 servlet에 셋팅 = action으로 받은거 jsp로 넘기기위해 Attribute
				list = dao.listAll();
			}else if(action.equals("delete")&&tmpId!=null) {
				if(dao.delete(Integer.parseInt(tmpId))) {  //delete기능 함수는 dao에있음 // id값 제대로 받으면 -jsp=화면에 메세지출력
					request.setAttribute("msg","삭제됨");
				}else {
					request.setAttribute("msg", "삭제안됨");
				}	
				list = dao.listAll();
			}else if(action.equals("search")) {
				list=dao.search(key,searchType);
			}else if (action.equals("listwriter")) {
				list=dao.search(key,"writer");
			}
			//action이나 id 값 받는거 필요없이 기본적으로 리스트 노출이니 바로 servlet에 셋팅= jsp로 넘기기위해
		}else {
			list = dao.listAll();
		}
		request.setAttribute("list", list);
		//다하면 jsp로 foward 요청함 
		// getRequestDispatcher=A페이지에서 B페이지로 이동할 때, A페이지에서 가지는 request값을 B페이지로 전달할 수 있다
		request.getRequestDispatcher("jspexam/Newsview.jsp").forward(request, response);
		
	}
	
	/* form태그에 post= 사용자 입력한거 반응보이는것 
	 *  뉴스 작성 =write
	 *  뉴스 수정=update
	 *  
	 *  작성자/제목/내용 필요
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); //한글로 쓴거 servlet에 받아 셋팅 

		String action = request.getParameter("action");
		String id = request.getParameter("id");//vo에 id객체는 id리턴 =jsp에서 getID로 받은거
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsVO vo = new NewsVO(); //vo 에 get 한거 넣어주기위해 객체 만듦
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);

		NewsDAO dao = new NewsDAO(); //dao에 함수 사용위해 객체 만듦

		if (action.equals("insert")) { //뉴스 작성
			boolean result = dao.insert(vo); //insert에 vo에 담은거 다 넣고 , boolean이니 결과값으로 돌림

			if (result) { //boolean으로 리턴된 값에 따라
				request.setAttribute("msg", "뉴스가 성공적으로 입력되었어요!!!"); //jsp에 msg 보이기위해 servlet에 셋팅
			} else {
				request.setAttribute("msg", "뉴스입력에 실패하게 되었어요!!!");
			}

		} else if (action.equals("update")&&id!=null) { //뉴스 수정
			vo.setId(Integer.parseInt(id));
			boolean result = dao.update(vo);

			if (result) {
				request.setAttribute("msg", "뉴스가 성공적으로 수정되었어요!!!");
			} else {
				request.setAttribute("msg", "뉴스 수정에 실패하게 되었어요!!!");
			}
		}
		request.setAttribute("list", dao.listAll()); //post에서도 항상 리스트 보이기 위해
		request.getRequestDispatcher("jspexam/Newsview.jsp").forward(request, response);
	}
}
