package com.springbook.ioc.indjection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class collectionbeanclient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appilcationcontext.xml");
		collectionbean bean =(collectionbean)factory.getBean("collectionbean");
		List<String> list= bean.getAddresslist();
		
		System.out.println("----------리스트");
		for(String st : list){
			System.out.println(st);
		}
		System.out.println("----------set");
		Set<String> set= bean.getAddressSet();
		for(String st:set) {
			System.out.println(st);
		}
		System.out.println("----------map");
		Map<String , String> map= bean.getAddressMap();
		for(String key : map.keySet()) {
			System.out.println(key+","+map.get(key));
		}
		
		System.out.println("----------프로퍼티");
		Properties proper=  bean.getAddproperties();
		
		
		
		factory.close();
	}

}
