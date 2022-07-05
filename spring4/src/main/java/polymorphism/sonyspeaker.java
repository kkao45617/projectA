package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class sonyspeaker implements speaker{
	public sonyspeaker() {
		System.out.println("sonyspeak 생성자");
	}
	public void volumeup() {
		System.out.println("sony 볼륨업");
	}
	public void volumedown() {
		System.out.println("sony 볼륨다운");
	}
	
}
