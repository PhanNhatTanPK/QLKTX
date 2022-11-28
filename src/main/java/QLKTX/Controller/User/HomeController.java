package QLKTX.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView Index() {		
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
}
