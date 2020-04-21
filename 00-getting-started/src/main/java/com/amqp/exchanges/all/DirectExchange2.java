package com.amqp.exchanges.all;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Selective message broadcast with routingkey filter.
 */
public class DirectExchange2 {

  //Step-5: Publish the messages
  public static void publishMessage() throws IOException, TimeoutException {
    Channel channel = ConnectionManager.getConnection().createChannel();


		  String message = "Direct message - Turn on the Home Appliances " + 2;
		  channel.basicPublish("my-direct-exchange", "homeAppliance", null, message.getBytes());
	  channel.close();


  }

  public static void main(String[] args) throws IOException, TimeoutException {

    DirectExchange2.publishMessage();

  }
}
