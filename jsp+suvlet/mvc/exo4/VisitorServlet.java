package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.VisitorDAO;
import model.vo.VisitorVO;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		
		VisitorDAO dao = new VisitorDAO();
		
		if(id!=null) {
			boolean result =dao.delete(Integer.parseInt(id));
			if(result)
				request.setAttribute("msg", "글 삭제 성공");
			else
				request.setAttribute("msg", "글 삭제 실패");
		}
		else if(keyword == null) {
			request.setAttribute("list", dao.listAll());
			
		} else {
			ArrayList<VisitorVO> list = dao.search(keyword);
			if(list==null) {
				request.setAttribute("msg", keyword+"검색 불가");
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/visitorView.jsp")
        .forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String memo=request.getParameter("content");
		VisitorDAO dao=new VisitorDAO();
		VisitorVO vo=new VisitorVO();
		vo.setName(name);
		vo.setMemo(memo);
		boolean result=dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"님의 글이 성공적으로 입력되었어요!!!");
		}else {
			request.setAttribute("msg", name+"님의 글 입력에 실패하게 되었어요!!!");
		}
		request.getRequestDispatcher("/jspexam/visitorView.jsp").forward(request,response);
		
	}

}
