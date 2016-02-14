package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		//session.setMaxInactiveInterval(5);
		System.out.println("new a session: " + session);
		System.out.println(session.getId());
		System.out.println(session.getLastAccessedTime());
		System.out.println(session.getCreationTime());

		//session.invalidate();
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	
		HttpSession session = se.getSession();
		System.out.println("destory a session: " + session);
	}

}
