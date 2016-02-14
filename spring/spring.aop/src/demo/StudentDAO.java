package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class StudentDAO implements DAO
{

	@Override
	public void insert(Student instance) {
		System.out.println("insert...");
	}
	
	public void update(Student instance) {
		System.out.println("update...");
	}
}
