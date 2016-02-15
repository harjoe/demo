package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bridge.demo.Car;

public class CarTest {

	@Test
	public void test() {
		
		Car car = new Car();

		car.setName("bridge");
		
		System.out.println(car.getName());
		
		fail("Not yet implemented");
	}

}
