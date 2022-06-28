package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		AbstractApplicationContext factory= new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv= (TV)factory.getBean("tv");
		tv.poweron();
		tv.poweroff();
		tv.volumeup(); 
		tv.volumedown();
		
		factory.close();
		
		
		
	}

}
