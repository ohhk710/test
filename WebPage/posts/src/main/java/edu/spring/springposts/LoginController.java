package edu.spring.springposts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDAO;
import vo.SignupVO;

@Controller
@SessionAttributes({ "vo" })

public class LoginController {
	@Autowired
	private LoginDAO dao;

	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView doGET() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	// 로그인 활성화시키기
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(SignupVO vo) {// jsp에서 받는 아이디와 비번 vo
		ModelAndView mav = new ModelAndView(); // 로그인 클릭시 아이디와 비번 받고 비교한 값이 맞는지 확인후 메인페이지로 이동시킴

		SignupVO result = dao.logininfo(vo);// 받은 vo를 dao에 db와 연결해서 반환값에 결과에 따른 과정 진행

		if (result != null) {// db에 아이디와 비번 존재
			mav.addObject("vo", result);

			mav.setViewName("login"); // main으로 이동 주소바꾸기~~~~~~~

		} else {// db에 아이디 비번 없음
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			mav.addObject("msg", "로그인에 실패하였습니다");
			mav.setViewName("redirect:/login");

		}
		return mav;

	}

	// 회원가입 첫화면
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		return "signup";
	}

//	//회원가입 form 태그- 완성시 login 화면으로 ㄱㄱ
//	@RequestMapping(value="/signup", method=RequestMethod.POST)
//	public ModelAndView signup(SignupVO vo) {
//		ModelAndView mav=new ModelAndView();
//		
//		boolean result=dao.signup(vo);
//		if(result==true) {
//			mav.addObject("vo", result);
//			mav.setViewName("login");
//		}
//		else {
//			System.out.println("가입 실패");
//			mav.setViewName("signup");
//		}
//		return mav;
//	}

	@RequestMapping(value = "/chkid", method = RequestMethod.GET)
	@ResponseBody
	public int chkid(@RequestParam("u_id") String u_id) {
		return dao.chkid(u_id);
	}
	
	@RequestMapping(value="/chkemail", method=RequestMethod.GET)
	@ResponseBody
	public int chkemail(@RequestParam("email") String email) {
		return dao.chkemail(email);
	}
}
