package edu.spring.redu;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rtest.OnePersonService;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonService ops;
	
	@RequestMapping("/map7")
	public ModelAndView get8(String gu, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String real_path = req.getSession().getServletContext().getRealPath("/");
		System.out.println(real_path);
	    real_path = real_path.replace("\\", "/");
	    System.out.println(real_path);		
		File f = new File(real_path+"/resources/indexOneperson");
		if(!f.exists()) f.mkdir();
		String result = ops.returnLeaflet1(real_path+"/resources/indexOneperson",gu);
		mav.addObject("indexOneperson", "http://localhost:8000/redu/resources/indexOneperson/"+result);
		mav.setViewName("oneView");
		return mav;
	}	

}
