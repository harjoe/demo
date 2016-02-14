package java.exception;

public class Student
{

	public String getName() throws Exception{
		
		throw new Exception("aa");
		
	}
	
	public String getAge(){
		
		throw new RuntimeException("r");
	}
	
}
