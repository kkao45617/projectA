package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 호출");
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("samsungTV(1) 생성자");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("samsungTV(2) 생성자");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("samsungTV(3) 생성자");
		this.speaker = speaker;
		this.price = price;
	}
	
//	void AAA() {
//		System.out.println("AAA 초기화 메소드");
//	}
//	
//	void BBB() {
//		System.out.println("BBB 소멸전 메소드");
//	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 ON  (가격 : " + price + ")");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원 OFF");
	}
	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV---소리 UP");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV---소리 DOWN");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
