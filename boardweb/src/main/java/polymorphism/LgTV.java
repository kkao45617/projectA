package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")

public class LgTV implements TV {
//	@Autowired
//	@Qualifier("appleSpeaker")
	@Resource(name="apple")
	private Speaker speaker;
	private int price = 500;
	
	public LgTV() {
		System.out.println("lgTV 생성자");
	}
	public LgTV(Speaker speaker) {
		System.out.println("LgTV(2) 생성자");
		this.speaker = speaker;
	}
	
	public LgTV(Speaker speaker, int price) {
		System.out.println("LgTV(3) 생성자");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("LgTV---전원 ON  (가격 : " + price + ")");
	}
	public void powerOff() {
		System.out.println("LgTV---전원 OFF");
	}
	public void volumeUp() {
//		System.out.println("LgTV---소리 UP");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("LgTV---소리 DOWN");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
