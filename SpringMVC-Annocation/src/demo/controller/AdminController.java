package demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, ModelMap map){
		
		request.getSession().setAttribute("name", "bridge");
		return "logined";
	}
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap map){
		String name = (String)request.getSession().getAttribute("name");
		if (name != null)
			return "list";
		else
			return "login";
	}
	
	
}
