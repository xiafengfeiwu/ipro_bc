package com.rabbit.test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MainConsumerTest {

	private final static String EXCHANGE = "TeamUnionExchange";// topic类型交换器
	private final static String TYPE = "topic";
	private final static String QUEUE = "TeamUnionQueue";
	private final static String ROUTING_KEY = "TeamUnionAlert";

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = null;

		try {

			factory.setPort(5672);
			factory.setHost("120.25.192.56");
			factory.setUsername("guest");
			factory.setPassword("guest");
			connection = factory.newConnection();
			// 创建连接
			final Channel channel = connection.createChannel();
			// 声明交换器队列绑定等信息
			channel.exchangeDeclare(EXCHANGE, TYPE, true);
			channel.queueDeclare(QUEUE, false, false, false, null);
			channel.queueBind(QUEUE, EXCHANGE, ROUTING_KEY);

			Consumer critical_notify = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					String msg = new String(body, "UTF-8");
					long time = new Long(msg);
					System.out.println(new Date().getTime() - time);
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			};
			// 消息消费
			channel.basicConsume(QUEUE, false, "critical", critical_notify);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
