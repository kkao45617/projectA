package polymorphism;

public class SnoySpeaker implements speaker{
	public SnoySpeaker() {
		System.out.println("소니 스피커 객체생성");
	}
	public void volumeup() {
		System.out.println("소니 스피커 볼륨 올리기");
	}
	public void volumedown() {
		System.out.println("소니 스피커 볼륨 낮추기");
	}

}
