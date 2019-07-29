//package edu.spring.springposts;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import dao.DeleteDAO;
//import vo.SignupVO;
//
////@SessionAttributes("vo") // session.getattribues��� ���� ��� . ���ǿ� ������ ��ü�̸�
//@Controller
//public class DeleteController {
//	@Autowired
//	DeleteDAO dao;
//
//	// 계정삭제
//	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
//	public ModelAndView deleteAccount(SignupVO vo, @RequestParam String passwd) {
//		ModelAndView mav = new ModelAndView();
//		
//		boolean result = dao.chkpasswd(vo);
//		System.out.println(vo.toString());
//		System.out.println("result" + result);
//		if (result) {
//			System.out.println(vo.toString());
//			dao.deleteAccount(vo.getU_id());
//			mav.addObject("msg", "계정이 삭제되었습니다");
//			
//			mav.setViewName("deleteAccount"); // 로그인페이지로
//			
//		} else {
//			mav.addObject("msg", "비밀번호가 틀렸습니다.");
//			mav.setViewName("deleteAccount");
//			
//		}return mav;
//	}
//
//	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
//	public ModelAndView doGET() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("deleteAccount");
//		return mav;
//	}
//
//	// 이메일변경
//	@RequestMapping(value = "/email", method = RequestMethod.POST)
//	public ModelAndView updateEmail(SignupVO vo) {
//		ModelAndView mav = new ModelAndView();
//		if (dao.updateEmail(vo)) {
//			mav.addObject("msg", "이메일이 변경되었습니다.");
//			mav.addObject("vo", vo);
//			mav.setViewName("deleteAccount");
//		}
//		else {
//			mav.addObject("msg", "이메일이 변경이 실패했습니다.");
//			mav.addObject("vo", vo);
//			mav.setViewName("deleteAccount");
//		}
//		return mav;
//	}
//
//	// 패스워드변경
//	@RequestMapping(value = "/passwd", method = RequestMethod.POST)
//	public ModelAndView updatePasswd(SignupVO vo) {
//		ModelAndView mav = new ModelAndView();
//		if (dao.updatePasswd(vo)) {
//			mav.addObject("msg", "비밀번호가 변경되었습니다.");
//			mav.addObject("vo", vo);
//			mav.setViewName("deleteAccount");
//		}
//		else {
//			mav.addObject("msg", "비밀번호 변경이 실패했습니다.");
//			mav.addObject("vo", vo);
//			mav.setViewName("deleteAccount");
//		}
//		return mav;
//	}
//}