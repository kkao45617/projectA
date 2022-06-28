package com.springbook.ioc.injection;

import java.util.List;

public class CollectionBean {
	private List<String> addressList;
	public void setAddressList(List<String> addresslist) {
		this.addressList= addresslist;
	}
	public List<String> getaddresslist(){
		return addressList;
	}
	
}
