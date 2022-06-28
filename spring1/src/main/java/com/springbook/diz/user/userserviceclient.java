package com.springbook.diz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class userserviceclient {
	public static void main(String[] args) {
		AbstractApplicationContext container= new GenericXmlApplicationContext("appilcationcontext2.xml");
		
		userservice userservice = (userservice)container.getBean("userservice");
		
		userVO vo = new userVO();
		vo.setId("test");
		vo.setPassword("1234test");
		
		userVO user = userservice.getuser(vo);
		if(user !=null) {
			System.out.println(user.getName()+"님 환영합니다");
		}else {
			System.out.println("로그인 실패");
		}
		
		container.close();
	}
}
