package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.OnePersonDAO;
import vo.OnePersonVO;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonDAO dao;

	@RequestMapping("/one")
	ModelAndView select(@RequestParam(defaultValue="false") String nb, OnePersonVO vo) {
		ModelAndView mav = new ModelAndView();
		List<OnePersonVO> list =null;
		System.out.println(nb);
		if (nb.equals("1")) {
			list=dao.select1();
			mav.addObject("list1", list);

		} else if (nb.equals("2")) {
			list = dao.select2();
			mav.addObject("list2", list);

		} else if (nb.equals("3")) {
			list = dao.select3();
			mav.addObject("list3", list);

		} else if(nb.equals("4")){
			list = dao.select4();
			mav.addObject("list4", list);

		}
		
		if(vo.getGu()!=null) {
			list=dao.search(vo.getGu());
			mav.addObject("list1", list);
		}
		
		mav.setViewName("OnePersonView");
		return mav;
	}

}
