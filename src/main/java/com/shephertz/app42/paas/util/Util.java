package com.shephertz.app42.paas.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;

import com.shephertz.app42.paas.test.TestBM;

public class Util {

	public static Logger logger = Logger.getLogger(TestBM.class);

	/*
	 * Static initializer
	 * 
	 * Done to load files
	 */
	static Properties prop = new Properties();
	static File file = null;
	static {
		try {
			// file = new File("src/main/resources/Config.properties");
			prop.load(new FileInputStream("/root/aws.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getInstanceId() {
		String instanceId = "";
		if (!prop.getProperty("instance_id").toString().equals("")) {
			instanceId = prop.getProperty("instance_id").toString();
		}
		return instanceId;
	}
}
