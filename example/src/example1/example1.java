package example1;

public class example1 {

	public static void main(String[] args) {
		student s= new student();
		s.name="홍길동";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;
		
		System.out.println("이름:"+s.name);
		System.out.println("총점:"+s.gettotal());
		System.out.println("평균:"+s.getaverge());
	}
	
}
class student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	//수학 + 영어+ 한국어
	public int gettotal() {
		return math+kor+eng;
	}
	public int getaverge() {
		return gettotal()/3;
	}
}