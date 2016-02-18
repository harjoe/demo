package test;

import static org.junit.Assert.*;
import hello.Car;
import hello.HelloBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car car = (Car) context.getBean("car");

		car.run();

		fail("Not yet implemented");
	}
	
	@Test
	public void testHello(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloBean bean = (HelloBean) context.getBean("helloBean");
		System.out.println(bean.getHelloWorld());
		
	}

}
