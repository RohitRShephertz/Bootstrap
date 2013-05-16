package com.shephertz.app42.paas.bootstrap.service;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;

import com.shephertz.app42.paas.bootstrap.BootstrapManager;
import com.shephertz.app42.paas.test.TestBM;
import com.shephertz.app42.paas.util.Util;

public class SharedBootstrapManager implements BootstrapManager {

	@Override
	public void sendMessage() throws Exception, JSONException {
		// TODO Auto-generated method stub
		String instanceId = Util.getInstanceId();
		System.out.println("INSTANCE ID: "+instanceId);
		Message<?> message = MessageBuilder.withPayload(instanceId)
				.setHeader("messageType", "1")
				.setHeader("requestType", "shared")
				.setHeader("reserved", "0").setHeader("payloadType", "1")
				.setHeader("action", "bootstrap").build();

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:main/resources/META-INF/spring/integration/app42-bootstrap-manager-context.xml");
		MessageChannel toJMS = context.getBean("toJMS",
				MessageChannel.class);
		MessagingTemplate template = new MessagingTemplate();
		template.convertAndSend(toJMS, message);
		System.out.println("Message Sent: ");
	}

}