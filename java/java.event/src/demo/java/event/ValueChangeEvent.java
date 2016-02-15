package demo.java.event;

import java.util.EventObject;

public class ValueChangeEvent extends EventObject
{
	private int value;
	
	public ValueChangeEvent(Object source) {
		this(source, 0);
		// TODO Auto-generated constructor stub
	}
	
	
	public ValueChangeEvent(Object source, int newValue) {
		super(source);
		value = newValue;
	}
	
	public int getValue(){
		return value;
	}


}
