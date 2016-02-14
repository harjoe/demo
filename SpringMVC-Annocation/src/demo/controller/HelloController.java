package demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	
	@RequestMapping("/hello")
	public String load(HttpServletRequest request, ModelMap map){
		
		return "hello";
	}
	
}
