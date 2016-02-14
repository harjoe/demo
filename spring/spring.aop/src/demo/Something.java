package demo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Aspect
public class Something
{
	public void borrowBook() {
		System.out.println("borrow book.");
	}

	public void returnBook(){
		System.out.println("return book");
	}
}
