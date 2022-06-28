package polymorphism;

public class beanfactory {
	public Object getbean(String beanname) {
		if(beanname.equals("samsung")) {
			return new samsungTV();
		}else if(beanname.equals("LGtv")) {
			return new LGtv();
		}
		return null;
	}
}
