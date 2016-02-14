package listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import servlet.StudentServlet;

public class HelloRequestListener implements ServletRequestListener {


	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("get a request");
		
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		System.out.println(request.getRequestURL());
		
		
		/*
		StudentServlet studentServlet = new StudentServlet();
		try {
			studentServlet.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			studentServlet.doGet((HttpServletRequest)sre.getServletRequest(), null);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("destory a request");
	
		
	}
	


}
