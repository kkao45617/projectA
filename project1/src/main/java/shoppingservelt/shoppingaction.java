package shoppingservelt;

import controller.shopping;
import controller.shoppinglist;
import controller.shoppingwrite;
import controller.shoppingwrite2;

public class shoppingaction {
	private static shoppingaction instance = new shoppingaction();
	private shoppingaction() {
		
	}
	public static shoppingaction getinstance() {
		return instance;
	}
	
	public shopping getshopping(String link) {
		shopping shopping=null;
		System.out.println("handeling : "+link);
		
		if(link.equals("write_form")) {
			shopping = new shoppingwrite();
		}else if(link.equals("shopping_write")) {
			shopping = new shoppingwrite2();
		}else if(link.equals("list")) {
			shopping=new shoppinglist();
		}else if(link.equals("view")) {
			shopping=new shoppingview();
		}
		
		
		return shopping;
	}
}
