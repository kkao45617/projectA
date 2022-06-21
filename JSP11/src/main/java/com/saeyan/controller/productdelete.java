package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.productdao;
import com.saeyan.dto.productvo;

@WebServlet("/productdelete.do")
public class productdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code= Integer.parseInt(request.getParameter("code"));
		
		
		productdao pdao = productdao.getinstance();
		productvo pvo=new productvo();
		pvo.setCode(code);
		pdao.productdelete(pvo);
		response.sendRedirect("productlist.do");
	}
}
