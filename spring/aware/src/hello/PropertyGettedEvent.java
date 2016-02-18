package hello;

import org.springframework.context.ApplicationEvent;

public class PropertyGettedEvent extends ApplicationEvent
{

	public PropertyGettedEvent(Object object) {
		super(object);
	}
}
