package demo.service.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class StudentValidator
{
	@Pointcut("target(demo.service.StudentService)")
	public void myMethod(){
		
	}
	
	@Before("myMethod")
	public void before(){
		System.out.println("before");
	}
	
	@After("myMethod")
	public void after(){
		System.out.println("after");
	}
	
	
	
	
	public void insert() {
		System.out.println("insert validator");
	}
	
	public void update(){
		System.out.println("update validator");
	}
}
