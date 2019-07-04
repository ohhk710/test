package my.spring.springedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.LoginService;
import vo.LoginVO;
import vo.ResultVO;

@Controller
public class LoginController {
	@Autowired
	LoginService ls; // 의존형으로 주입함
	// private LoginService loginService; 가능

	@RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
	@ResponseBody // 응답시 view가 아닌 여기서 직접 응답하겠다/=컨트롤러가 직접 JSON 형식으로 응답한다
	public ResultVO login(LoginVO loginVO) {
		ResultVO vo = new ResultVO();
		if (ls.login(loginVO.getId(), loginVO.getPasswd())) {
			vo.setResult("ok"); // ResultVO 객체의 result 변수에 "ok"를 저장하고 
		} else {
			vo.setResult("fail");
		}
		return vo;
	}
}
