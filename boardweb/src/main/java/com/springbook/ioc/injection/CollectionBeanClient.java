package com.springbook.ioc.injection;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.ioc.injection.CollectionBean;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("CollectionBean");
		List<String> list = bean.getAddressList();
		for(String address : list) {
			System.out.println("========list=========");
			System.out.println(address);
		}
		System.out.println("========set=========");
		
		Set<String> set = bean.getAddressSet();
		for(String address : set) {
			System.out.println(address);
		}
		System.out.println("========map=========");
		
		Map<String, String> map = bean.getAddressMap();
		for(Entry<String, String> esm : map.entrySet()) {
			System.out.println(esm.getKey()+" - " + esm.getValue());
		}
		System.out.println("=========properties========");
		Properties pr = bean.getAddressProperties();
		Enumeration en = pr.propertyNames();
		while(en.hasMoreElements()) {
			System.out.println(en+ "=" + pr.getProperty(null, null));
		
		}
		factory.close();
	}

}
