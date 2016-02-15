package demo.java.event;

import java.util.EventListener;

public interface ValueChangeListener extends EventListener 
{
	public void performed(ValueChangeEvent e);
}
