package com.rabbit.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MainSendTest2 {
	private static Connection connection;
	static {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			factory.setUsername("sizhongxia");
			factory.setPassword("123456");
			factory.setPort(5672);
			connection = factory.newConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testSend() {
		try {
			Channel channel = connection.createChannel();
			System.out.println(channel.toString());
			byte[] messageBodyBytes = "hello world".getBytes();
			channel.basicPublish("TeamUnionExchange", "TeamUnionAlert", MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		testSend();
	}
}
