package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.SubwayDAO;
import vo.SubwayVO;

@Controller
public class SubwayController {
	@Autowired 
	SubwayDAO dao;
	
	@RequestMapping("/subwayselect1")
	ModelAndView selectData1(@RequestParam String line) {
		ModelAndView mav = new ModelAndView();
		List<SubwayVO> list = dao.select1(line);
		
		mav.addObject("list1", list);
		mav.setViewName("subwayView");
		return mav;	
	}


}
