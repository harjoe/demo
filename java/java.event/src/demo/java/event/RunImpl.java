package demo.java.event;

public class RunImpl implements RunEvent
{

	@Override
	public void run(String message) {

		System.out.println(message);
		
	}

}
