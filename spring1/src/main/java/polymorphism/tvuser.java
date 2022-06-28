	package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class tvuser {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("appilcationcontext.xml");
		
		
		TV tv1= (TV)factory.getBean("samsungTV");
		tv1.poweron();
		tv1.pweroff();
		tv1.volumedown();
		tv1.volumeup();
		factory.close();
	
	}
}
