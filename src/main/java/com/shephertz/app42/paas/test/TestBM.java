package com.shephertz.app42.paas.test;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shephertz.app42.paas.bootstrap.service.SharedBootstrapManager;

public class TestBM {

	/**
	 * @param args
	 * @throws Exception
	 * @throws JSONException
	 */
	public static void main(String[] args) throws JSONException, Exception {
		// TODO Auto-generated method stub
		System.out.println("Main Called");
		new SharedBootstrapManager().sendMessage();
	}

}
