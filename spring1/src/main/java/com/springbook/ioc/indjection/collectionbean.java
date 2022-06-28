package com.springbook.ioc.indjection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class collectionbean {
	private List<String> addresslist;
	private Set<String> addressSet;
	private Map<String, String> addressMap;
	private Properties addproperties;
	
	
	public Properties getAddproperties() {
		return addproperties;
	}

	public void setAddproperties(Properties addproperties) {
		this.addproperties = addproperties;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public List<String> getAddresslist() {
		
		return addresslist;
	}

	public void setAddresslist(List<String> addresslist) {
		this.addresslist = addresslist;
	}
	
}
