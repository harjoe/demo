package demo.java.util.BlockQueue;

public class Student {

	/**
	 * 
	 * */
	{
		this.name = "harjoe";
		System.out.println("set name: value is: " + this.name);
	}
	
	public Student(String name) {
		this.name = name;
		System.out.println("set name in Student(String): " + this.name);
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
