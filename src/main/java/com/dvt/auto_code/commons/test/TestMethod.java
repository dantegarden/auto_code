package com.dvt.auto_code.commons.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.junit.Test;

import com.dvt.auto_code.commons.utils.HttpHelper;
import com.dvt.auto_code.commons.utils.XmlRpcUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TestMethod {
	@Test
	public void testHttp(){
		Map<String, String> params = Maps.newHashMap();
		params.put("data", "{\"address\":\"test-xsxx\",\"params\": {},\"token\":\"C1A035457E5CF01B69A4270529F86638\"}");
		String s1;
		try {
			s1 = HttpHelper.startPost("http://222.197.182.5:7018/datacenter/rest/dataservicesearch/QueryServiceData", params);
			System.out.println(s1);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	//@Test
	public void test(){
		File file = new File("D:/test.20170818");
		List<String> citys = ImmutableList.of("Beijing","Shanghai","Chongqing","Tianjin","Shijiazhuang","Baoding","Hangzhou","Shenyang","Kunming","Shenzhen","Guangzhou");
		List<String> months = ImmutableList.of("201701","201702","201703","201704","201705","201706","201707","201708","201709","201710","201711","201712");
		try {
			if(!file.exists()&&file.isFile()){
				file.createNewFile();
			}
			List<String> cache = Lists.newArrayList();
			while(file.length()<1048576L*1024){
				String city  = citys.get(new Random().nextInt(citys.size()));
				String month  = months.get(new Random().nextInt(months.size()));
				Long count =  (long)(Math.random() * 100000);
				String line = city + "|" + month + "|" + count;
				cache.add(line);
				if(cache.size()==100){
					FileUtils.writeLines(file, cache, Boolean.TRUE);
					cache.clear();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void test2() throws Exception{
		final String URL = "http://localhost:8069"; 
	    //final String DB = "hospital-mh";  
	    //final int USERID = 1;  
	    //final String PASS = "123456";  
	    List<String> emptyList = Lists.newArrayList();
		
	    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();  
		XmlRpcClient client = new XmlRpcClient();
		
	    config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", URL)));  
	    client.setConfig(config);
		Object obj = client.execute(config, "authenticate", Arrays.asList(
        "hospital-mh", "admin", "123456", Maps.newHashMap()));
		 
        
        if(obj != null){
        	System.out.println(obj.toString());
        }
	}
}
