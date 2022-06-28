package polymorphism;

public class SamsungTV implements TV{
	private speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("삼성 tv 객체 1 생성");
	}
	public SamsungTV(speaker speaker) {
		System.out.println("=====> samsungtv 객체 2 생성");
		this.speaker = speaker;
	}
	public SamsungTV(speaker speaker, int price) {
		System.out.println("======>삼성 객체 3 생성");
		this.speaker=speaker;
		this.price=price;
	}
	
	
	public void setSpeaker(speaker speaker) {
		System.out.println("setspeaker()호출");
		this.speaker=speaker;
	}
	public void setPrice(int price) {
		System.out.println("setprice()호출");
		this.price=price;
	}
	
	public void poweron(){
		System.out.println("삼성tv----전원켜기 가격("+price+")원" );
	}
	public void poweroff() {
		System.out.println("삼성tv------전원끄기");
	}
	public void volumeup() {
		//System.out.println("삼성tv------소리올린다");
	
		speaker.volumeup();
	}
	public void volumedown() {
		//System.out.println("삼성tv------소리 내린다.");
		
		speaker.volumedown();
	}
}
