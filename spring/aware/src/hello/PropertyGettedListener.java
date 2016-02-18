package hello;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class PropertyGettedListener implements ApplicationListener
{

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		
		System.out.println(arg0.getSource().toString());
		
	}

}
