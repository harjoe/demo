package jms.helloworld;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer
{
	public static void main(String[] args) throws JMSException {
		String username = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("hello");
		MessageConsumer consumer = session.createConsumer(destination);
		
		System.out.println("receive...");
		
		while (true) {
			TextMessage message = (TextMessage)consumer.receive(100000);
			if (message != null)
				System.out.println("receive: " + message.getText());
			else
			{
				
				System.out.println("blank");
				break;
			}
			
		}

		System.out.println("receive finished.");
	}

}
