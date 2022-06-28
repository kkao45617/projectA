package com.springbook.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class collectionbeanclient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("-----------------list");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionbean");
		List<String> addresslist = bean.getaddresslist();
		for(String add:addresslist) {
			System.out.println(add);
		}
		
		System.out.println("-----------------set");
		List<String> set = bean.getaddresslist();
		for(String add:set) {
			System.out.println(add);
		}
		
		System.out.println("---------------map");
		
		//스프링책 95페이지
		
		
	}
}
