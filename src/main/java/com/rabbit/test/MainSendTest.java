package com.rabbit.test;

import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MainSendTest {
	private static final String EXCHANGE_NAME = "TeamUnionExchange";
	private static final String ROUTING_KEY = "TeamUnionAlert";

	public static void main(String[] argv) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("120.25.192.56");
			factory.setUsername("guest");
			factory.setPassword("guest");
			factory.setPort(5672);
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
			while (true) {
				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, (new Date().getTime() + "").getBytes());
				Thread.sleep(800);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception ignore) {
				}
			}
		}
	}
}
