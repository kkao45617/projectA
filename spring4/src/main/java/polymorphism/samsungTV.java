package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class samsungTV implements TV{
	//@Autowired
	//@Qualifier("applespeaker")
	@Resource(name = "sonyspeaker" )
	private speaker speaker;
	private int price;
	
	
	
	public void setSpeaker(speaker speaker) {
		System.out.println("setspeaker 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setprice호출");
		this.price = price;
	}

	public samsungTV() {
		System.out.println("samsung 생성자 호출 완료");
	}
	
	public samsungTV(speaker speaker) {
		System.out.println("samsungTV 생성자 1개");
		this.speaker=speaker;
	}
	
	public samsungTV(speaker speaker,int price) {
		System.out.println("samsungTV 생성자 2개");
		this.speaker=speaker;
		this.price=price;
		System.out.println("price : " + price);
	}
	void initmethod() {
		System.out.println("init method 초기화 메소드");
	}
	void destorymethod() {
		System.out.println("소멸전 메소드");
	}
	public void poweron() {
		System.out.print("samsung 전원 들어옴\n");
		System.out.printf("가격 : %d \n",price);
	}
	public void pweroff() {
		System.out.println("samsung 전원 꺼짐");
	}
	
	public void volumeup() {
		//System.out.println("samsung 소리 키우기");
		//speaker=new sonyspeaker();
		speaker.volumeup();
	}
	public void volumedown() {
		//System.out.println("samsung 소리 줄이기");
		//speaker= new sonyspeaker();
		speaker.volumedown();
	}
}
