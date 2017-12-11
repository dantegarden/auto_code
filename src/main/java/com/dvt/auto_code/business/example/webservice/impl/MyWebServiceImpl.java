package com.dvt.auto_code.business.example.webservice.impl;

import com.dvt.auto_code.business.example.webservice.MyWebService;

public class MyWebServiceImpl implements MyWebService {

	@Override
	public String SayHello(String name) {
		return "HelloWorld!! " + name;
	}
	
}
