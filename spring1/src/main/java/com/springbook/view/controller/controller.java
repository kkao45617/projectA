package com.springbook.view.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface controller {
	String handlerequest(HttpServletRequest request, HttpServletResponse response);
	
}
