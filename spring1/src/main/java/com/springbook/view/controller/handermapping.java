package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.deleteboardconteroller;
import com.springbook.view.board.getboardcontroller;
import com.springbook.view.board.insertboardcontroller;
import com.springbook.view.board.updateboardcontroller;
import com.springbook.view.user.getboardlistcontroller;
import com.springbook.view.user.logincontroller;

public class handermapping {
	private Map<String, controller> mappings;
	
	public handermapping() {
		mappings = new HashMap<String, controller>();
		mappings.put("/login.do", new logincontroller());
		mappings.put("/getboardlist.do", new getboardlistcontroller());
		mappings.put("/getboard.do", new getboardcontroller());
		mappings.put("/insertboard.do", new insertboardcontroller());
		mappings.put("/deleteboard.do", new deleteboardconteroller());
		mappings.put("/updateboard.do", new updateboardcontroller());
		
	}
	
	public controller getcontroller(String path) {
		System.out.println("getcontroller==>"+mappings.get(path));
		return mappings.get(path);
	}
}
