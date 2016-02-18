package hello;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class HelloBean implements ApplicationContextAware
{
	private ApplicationContext applicationContext;
	
	private String helloWorld = "hello";
	
	public String getHelloWorld() {
		applicationContext.publishEvent(new PropertyGettedEvent("get....."));
		
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;
		
	}

}
