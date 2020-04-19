package happy.rabitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {


	public static Connection getConnection() throws IOException, TimeoutException {
		String userName = "test";
		String password = "123456";
		String  hostName = "121.41.106.250";
		String  virtualHost = "my_test";
		int  portNumber = 5672;
		ConnectionFactory factory = new ConnectionFactory();
// "guest"/"guest" by default, limited to localhost connections
		factory.setUsername(userName);
		factory.setPassword(password);
		factory.setVirtualHost(virtualHost);
		factory.setHost(hostName);
		factory.setPort(portNumber);
		return  factory.newConnection();
	}
}
