package demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;


public class StudentController implements org.springframework.web.servlet.mvc.Controller {

	public StudentController() {
		System.out.println("Studetn action created...");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception {
		return new ModelAndView("/hello");
	}

}
