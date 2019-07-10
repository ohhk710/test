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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
@SessionAttributes("status")

public class NewsController {
	@Autowired
	NewsDAO dao;

	// 우선 뉴스 리스트부터
	@ModelAttribute("status") // 세션적용=특정리스트유지 - search를 해쉬로
	public HashMap<String,String> hashSearch() {
		return new HashMap<String,String>();
	}

	@RequestMapping("/newsMain") // 리스트 전체 출력 /세션없을때 전체리스트 유지
	public ModelAndView listAll(SessionStatus session) {
		ModelAndView mav = new ModelAndView();
		List<NewsVO> list=dao.listAll();
		mav.addObject("list", list);
		session.setComplete();
		mav.setViewName("news");
		return mav;
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView doGet(String action, NewsVO vo, @ModelAttribute("status") HashMap<String,String> status,
			String searchType, String key ) {
		ModelAndView mav = new ModelAndView();
		List<NewsVO> list = null;
		
		if (action.equals("read")) {
			NewsVO volistOne = dao.listOne(vo.getId());
			System.out.println(volistOne.toString());
			mav.addObject("vo1", volistOne);			
		} else if (action.equals("delete")) {
			if (dao.delete(vo.getId()))
				mav.addObject("msg", "뉴스성공");
			else
				mav.addObject("msg", "뉴스실패");
			
		} else {
			status = new HashMap<String,String>();
			status.put("key",key );
			status.put("searchType", searchType);
			status.put("action", action);
			
			if (action.equals("search")) {
				System.out.println("h1");
				list = dao.search(status);
			} else if (action.equals("listwriter")) {
				System.out.println("h2");
				list = dao.listWriter(status);	
			}
		}
		if(list==null) {
			if(status.containsKey("key")) {

				if (status.get("action").equals("search")) {
					list = dao.search(status);
					
				} else if (status.get("action").equals("listwriter")) {
					list = dao.listWriter(status);	
				}
			}else {
				list=dao.listAll();
			}
		}
		mav.addObject("list",list);
		mav.setViewName("news");
		return mav;
	}	

	@RequestMapping(value="/news",method= RequestMethod.POST)
	public ModelAndView doPost(String action, NewsVO vo, @ModelAttribute("status") HashMap<String,String> status ) {
		ModelAndView mav=new ModelAndView();
		List<NewsVO> list=null;
		
		if(action.equals("insert")) {
			boolean result =dao.insert(vo);
			if(result)
				mav.addObject ("msg","뉴스 입력 성공");
			else 
				mav.addObject ("msg","뉴스 수정 실패"); 
		}
		else if(action.equals("update")) {
			boolean result=dao.update(vo);
			if(result)
				mav.addObject("msg","뉴스 성공 수정");
			else
				mav.addObject("msg", "뉴스 수정 실패");
		}
		
		if(list==null) {
			if(status.containsKey("key")) {
				System.out.println("1");
					list = dao.search(status);
			}else {
				System.out.println("2");
				list=dao.listAll();
			}
		}
		mav.addObject("list", list);
		mav.setViewName("news");
		return mav;
	}

}
