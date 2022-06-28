package polymorphism;

public class LgTV implements TV{

	@Override
	public void poweron() {
		System.out.println("LGtv------전원올린다");
	}

	@Override
	public void poweroff() {
		System.out.println("LGtv--------전원내린다");
	}

	@Override
	public void volumeup() {
		System.out.println("LGtv-------소리올린다");
	}

	@Override
	public void volumedown() {
		System.out.println("LGtv---------소리내린다.");
	}

}
