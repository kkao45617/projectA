package example1;

public class example1 {

	public static void main(String[] args) {
		student s= new student();
		s.name="ȫ�浿";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;
		
		System.out.println("�̸�:"+s.name);
		System.out.println("����:"+s.gettotal());
		System.out.println("���:"+s.getaverge());
	}
	
}
class student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	//���� + ����+ �ѱ���
	public int gettotal() {
		return math+kor+eng;
	}
	public int getaverge() {
		return gettotal()/3;
	}
}