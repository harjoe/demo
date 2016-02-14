package demo;

import javax.ejb.ConcurrencyManagement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController
{

	//@Autowired
	//private Something something;
	
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		System.out.println("Studetn action created...");
	}
	
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap map) {
		//something.borrowBook();
		studentService.add(new Student());
		return "/index";
	}
}
