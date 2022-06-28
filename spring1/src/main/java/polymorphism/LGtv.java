package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LGtv implements TV{
	@Autowired
	@Qualifier("applespeaker")
	private speaker speaker;
	private int price;
	
	public LGtv() {
		System.out.println("lg 기본생성자");
	}
	public LGtv(speaker speaker) {
		System.out.println("생성자 호출 완료");
		this.speaker=speaker;
	}
	
	public LGtv(speaker speaker,int price) {
		System.out.println("lg 2개 생성자");
		this.speaker=speaker;
		this.price=price;
		System.out.println("speaker : "+speaker);
		System.out.println("price : "+price);
	}
	public void poweron() {
		System.out.println("LG 전원 들어옴");
	}
	public void pweroff() {
		System.out.println("LG 전원 꺼짐");
	}
	
	public void volumeup() {
		speaker.volumeup();
		//System.out.println("LG 소리 키우기");
		
	}
	public void volumedown() {
		speaker.volumedown();
		//System.out.println("LG 소리 줄이기");
		
	}
}
