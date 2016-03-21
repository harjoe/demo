package demo.properties.helloworld;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Tester {
	
	public static void main(String[] args) throws IOException {
		
		
		
		InputStream inputStream = Object.class.getResourceAsStream("/config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
  
		String name = properties.getProperty("name");
		String age = properties.getProperty("age");
		
		System.out.println(name);    
		System.out.println(age);
		
		properties.setProperty("remark", "hello world");
		System.out.println(properties.getProperty("remark"));
		OutputStream outputStream = new FileOutputStream("/config.properties");
		properties.store(outputStream, "aa");
		//inputStream.close();
		//outputStream.close();
	}

}
