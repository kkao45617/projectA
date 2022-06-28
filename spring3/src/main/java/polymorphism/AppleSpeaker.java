package polymorphism;

public class AppleSpeaker implements speaker{

	public AppleSpeaker() {
		System.out.println("애플 스피커 객체 생성");
	}
	
	@Override
	public void volumeup() {
		System.out.println("애플 스피커 볼륨 올린다");
	}

	@Override
	public void volumedown() {
		System.out.println("애플 스피커 볼륨 낮춘다");
	}
	

}
