package QLKTX.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import QLKTX.Entity.User;
import QLKTX.Service.User.AccountServiceImpl;


@Controller
public class UserController extends BaseController{
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView Register() {		
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new User());
		return _mvShare;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView Login() {		
		_mvShare.setViewName("user/account/login");
		_mvShare.addObject("user", new User());
		return _mvShare;
	}
	
	@RequestMapping(value = "listUser", method = RequestMethod.GET)
	public ModelAndView ListUser() {		
		_mvShare.setViewName("user/account/listUser");
		_mvShare.addObject("listUser", accountServiceImpl.GetAllUser());
		return _mvShare;
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") User user) {		
		int count = accountServiceImpl.AddAccount(user);
		if(count > 0) {
			_mvShare.addObject("statusRegister", "Successful registration");
		}
		else {
			_mvShare.addObject("statusRegister", "The account already exists.");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") User user) {		
		user = accountServiceImpl.CheckAccount(user);
		if(user != null) {	
			_mvShare.setViewName("redirect:home");
			session.setAttribute("UserInfo", user);
		}
		else {
			_mvShare.addObject("statusLogin", "Login failed");
		}
		
		return _mvShare;
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {		
		session.removeAttribute("UserInfo");
		return "redirect:" + request.getHeader("Referer");
	}
	
	 @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.GET)    
	    public String deleteProduct(HttpServletRequest request, @PathVariable int id){    
		 	accountServiceImpl.DeleteAccount(id);    
	        return "redirect:" + request.getHeader("Referer");  
	    } 
	
}
