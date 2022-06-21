package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.productdao;
import com.saeyan.dto.productvo;


@WebServlet("/productlist.do")
public class productlistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productdao pdao =productdao.getinstance();
		List<productvo> vo = pdao.selectallproducts();
		request.setAttribute("productlist", vo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productlist.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
