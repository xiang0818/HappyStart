package com.amqp.exchanges.all;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class ConnectionManager {

  private static Connection connection = null;

  /**
   * Create RabbitMQ Connection
   *
   * @return Connection
   */
  public static Connection getConnection() {
    if (connection == null) {
      try {
        ConnectionFactory connectionFactory = new ConnectionFactory();
	      connectionFactory.setUri("amqp://user:password@host:5672");
        connection = connectionFactory.newConnection();
      } catch (IOException | TimeoutException | URISyntaxException | NoSuchAlgorithmException | KeyManagementException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
