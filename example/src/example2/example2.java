package example2;

public class example2 {

	public static void main(String[] args) {
		Tv t = new Tv();
	}
	
}
class Product {
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ���� �� �����ϴ� ���ʽ�����
	Product(){}
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}
class Tv extends Product {
	public Tv(){}
	public String toString() {
		return "Tv";
	}
}