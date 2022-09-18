package vo;

public class test1 {
	
	int b;
	
	public void a() {
		System.out.println("가나다라");
	}
	public int b(int a) {
		
		return a;
	}
	
	public static void main(String[] args) {
		test1 a = new test1();
		
		a.a();
		System.out.println(a.b(3));
	}
}


class test2{
	int c;
}