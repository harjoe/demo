package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Authorize {

	public void doBefore(JoinPoint point) {
		System.out.println("authorize.before.");
		

	}

	public void doAfter() {
		System.out.println("authorize.after.");
	}
	
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("authorize.around");
		//joinPoint.
		// Object object = joinPoint.proceed();
		//
		// return object;
		//joinPoint.proceed();
		String name = (String)joinPoint.getArgs()[0];
		System.out.println(name);
		return 3;
	}
}
