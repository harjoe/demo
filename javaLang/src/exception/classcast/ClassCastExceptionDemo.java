package exception.classcast;

public class ClassCastExceptionDemo {

	public static void main(String[] args) {
		Object x = new Integer(0);
		System.out.println((String) x);
		
		Student student = new Student();
		student.setName("bridge");
		
		//System.out.println((Teacher) student);
	}

}
