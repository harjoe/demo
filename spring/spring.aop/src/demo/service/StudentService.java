package demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import demo.Student;
import demo.StudentDAO;


@Component("studentService")
public class StudentService
{
	
	public void add(Student student){
		
		System.out.println("add");
		//studentDAO.insert(student);
	}
		
}
