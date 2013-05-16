package com.shephertz.app42.paas.bootstrap;

import org.json.JSONException;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.message.GenericMessage;

public interface BootstrapManager {

	public void sendMessage() throws Exception, JSONException;
}
