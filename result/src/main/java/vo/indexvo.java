package vo;

import java.sql.Date;

public class indexvo {
	private int custno;
	private String custname,phone,address,gared,city;
	private Date joindate;
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGared() {
		return gared;
	}
	public void setGared(String gared) {
		this.gared = gared;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	
}
