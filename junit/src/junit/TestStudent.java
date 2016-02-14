package junit;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestStudent
{

	@Test
	public void test() {
		Student student = new Student();
		student.setName("bridge");
		student.flagName();
		
		int value = 22;
		Assert.assertEquals("error", value, 26);
		fail("Not yet implemented");
	}

	
	@Test
	public void test2(){
		Student student = new Student();
		student.setName("bridge");
		student.flagName();
		
		int value = 22;
		Assert.assertEquals("error", value, 26);
		fail("Not yet implemented");
		
	}
}
