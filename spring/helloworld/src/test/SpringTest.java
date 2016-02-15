package test;

import static org.junit.Assert.*;
import hello.Car;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test() {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car car = (Car) context.getBean("car");

		car.run();

		fail("Not yet implemented");
	}

}
