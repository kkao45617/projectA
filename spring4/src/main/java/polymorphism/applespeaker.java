package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class applespeaker implements speaker{
	public applespeaker() {
		System.out.println("applespeaker 객체 생성");
	}
	public void volumeup() {
		System.out.println("applespeaker 소리 올린다");
	}
	public void volumedown() {
		System.out.println("applespeaker 소리 내린다");
	}
}
