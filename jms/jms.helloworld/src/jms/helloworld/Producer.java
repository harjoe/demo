package jms.helloworld;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer
{

	public static void main(String[] args) throws JMSException {
		String username = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, url);

		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("hello");

		MessageProducer messageProducer = session.createProducer(destination);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ObjectMessage objectMessage = session.createObjectMessage();
			TextMessage message = session.createTextMessage("message " + i);
			//System.out.println("send: " + message.getText());
			messageProducer.send(message);
			objectMessage.setObject(arg0);
		}
		session.commit();
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
