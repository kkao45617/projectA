package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("SonySpeaker 생성자");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeaker -- volumUP");
		
	}
	
	public void volumeDown() {
		System.out.println("SonySpeaker -- volumDOWN");
		
	}

}
