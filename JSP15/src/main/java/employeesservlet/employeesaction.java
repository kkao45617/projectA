package employeesservlet;

import employcontroller.employdelete;
import employcontroller.employupdate;
import employcontroller.employupdateform;
import employcontroller.empoly;
import employcontroller.empolylist;
import employcontroller.empolyview;
import employcontroller.empolywrite;
import employcontroller.empolywriteform;

public class employeesaction {
	private static employeesaction instance = new employeesaction();
	private employeesaction() {
		
	}
	public static employeesaction getinstance() {
		return instance;
	}
	
	public empoly getempoly(String link) {
		empoly empoly=null;
		System.out.println("empoly : "+link);
		
		if(link.equals("list")) {
			empoly= new empolylist();
		}else if(link.equals("empoly_write_form")) {
			empoly= new empolywriteform();
		}else if(link.equals("empoly_write")) {
			empoly= new empolywrite();
		}else if(link.equals("employview")) {
			empoly=new empolyview();
		}else if(link.equals("employupdate")) {
			empoly=new employupdateform();
		}else if(link.equals("employ_update")) {
			empoly=new employupdate();
		}else if(link.equals("employdelete")) {
			empoly = new employdelete();
		}
		
		return empoly;
		
	}
}
