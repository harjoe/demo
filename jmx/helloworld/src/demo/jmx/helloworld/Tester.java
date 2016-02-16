package demo.jmx.helloworld;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Tester
{
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
		
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		ObjectName name = new ObjectName("mylogic:name=Car");
		server.registerMBean(new Car(), name);
		
		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter, port=8082");
		HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
		server.registerMBean(adaptorServer, adapterName);
		
		adaptorServer.start();
		
		Car car = new Car();
		car.run();
		
		
		System.out.println("......");
	}
}
