package edu.spring.springnews;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
@SessionAttributes("status")

public class NewsController {
	@Autowired
	NewsDAO dao;
		//우선 뉴스 리스트부터
		@ModelAttribute("status") //세션적용=특정리스트유지 - search를 해쉬로
		public HashMap hashSearch() {
			return new HashMap();
		}
	
		@RequestMapping("/newsmain") //리스트 전체 출력 /세션없을때 전체리스트 유지
		public ModelAndView listAll( ) {
			ModelAndView mav= new ModelAndView();
			mav.addObject("listAll",dao.listAll());
			return mav;
		}
		
		
		@RequestMapping(value="/news/{action}", method=RequestMethod.GET)
		public ModelAndView doGet(@PathVariable String action, NewsVO vo, @ModelAttribute("status") HashMap status, String searchType) {
			ModelAndView mav= new ModelAndView();
			
			if(action.equals("read")) {
				NewsVO volistOne=dao.listOne(vo.getId());
				mav.addObject("vo",volistOne);
				
			}else if(action.equals("delete")) {
				if(dao.delete(vo.getId()))
					mav.addObject("msg", "뉴스성공");
				else
					mav.addObject("msg", "뉴스실패");
			}
			else {
				status= new HashMap();
				status.put("key",searchType);
				if(action.equals("search")) {
					status =searchType;
				}
			}
		}
		
		
		@RequestMapping("/listOne")
		public ModelAndView listOne(int id) {
			ModelAndView mav= new ModelAndView();
			mav.addObject("listOne",dao.listOne(id))
		}
		
		@RequestMapping("/delete")
		
		@RequestMapping("/search")
	
		@RequestMapping("/writer")


	
	@RequestMapping(value="/update", method=Request.Method.Post)
}
