package demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentContorller {

	@RequestMapping("/index")
	public String list(HttpServletRequest request, ModelMap map) {
		
		System.out.println("student.list");
		
		return "/student/list";
		
	}

	@RequestMapping("edit")
	public String edit(HttpServletRequest request, ModelMap map) {
		
		System.out.println("student.edit");
		
		return "/student/edit";
	}
	
	
	/*
	@RequestMapping("/save")
	public String save(@RequestParam("name") String name, HttpServletRequest request, ModelMap map) {
		System.out.println("save");
		
		
		System.out.println(name);
		return "/student/edit";
	}
	*/
	@RequestMapping("/save")
	public String save(@ModelAttribute("student") Student student) {
		
		System.out.println("save");
		
		
		System.out.println(student.getName());
		return "/student/edit";
	}
	
}

