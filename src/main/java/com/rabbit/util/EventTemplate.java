package com.rabbit.util;

import com.rabbit.exception.SendRefuseException;

public interface EventTemplate {

	void send(String queueName, String exchangeName, Object eventContent) throws SendRefuseException;

	void send(String queueName, String exchangeName, Object eventContent, CodecFactory codecFactory) throws SendRefuseException;
}
