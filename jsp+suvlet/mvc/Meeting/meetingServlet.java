package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;


@WebServlet("/meeting")
public class meetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String keyword=request.getParameter("keyword");
			String id=request.getParameter("id");
			String action = request.getParameter("action");
			
			MeetingJDBCDAO dao=new MeetingJDBCDAO(); //인터페이스인 MeetingDAO는 객체화안됨
			
			if(keyword == null) {
				if(action == "delete") {
					boolean result = dao.delete(Integer.parseInt(id));
					if (result) {
						request.setAttribute("msg", "글이 성공적으로 삭제되었습니다.");
					} else {
						request.setAttribute("msg", "글이 삭제되지 않았습니다.");
					}
				} /*else if (action == "update") {
					boolean result = dao.selectOne(Integer.parseInt(id));
					if (result) {
						request.setAttribute("msg", "글이 성공적으로 삭제되었습니다.");
					} else {
						request.setAttribute("msg", "글이 삭제되지 않았습니다.");
					}
				}*/
				request.setAttribute("list", dao.listAll());
			}else {
				ArrayList<MeetingVO> list=dao.search(keyword);
				if(list.size() == 0) {
					request.setAttribute("msg", keyword+"검색 불가");
				}else {
					request.setAttribute("list", dao.search(keyword));
				}
			}
			request.getRequestDispatcher("jspexam/meetingView.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String meetingDate =request.getParameter("meetingdate");
		
		MeetingJDBCDAO dao=new MeetingJDBCDAO();
		MeetingVO vo=new MeetingVO();
		
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		
		boolean result=dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"님의 글이 성공적으로 입력되었어요!!!");
		}else {
			request.setAttribute("msg", name+"님의 글 입력에 실패하게 되었어요!!!");
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("jspexam/meetingView.jsp").forward(request,response);
		
	}

}