package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {


	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("get a request");
		
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		System.out.println(request.getRequestURL());
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("destory a request");
		
	}


}
