package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.productdao;
import com.saeyan.dto.productvo;


@WebServlet("/productupdate.do")
public class productupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		productdao pdao = productdao.getinstance();
		productvo pvo= pdao.selectproductbycode(code);
		request.setAttribute("product", pvo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productupdate.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		String path=context.getRealPath("uploadfile");
		String enctype = "utf-8";
		int sizelimit = 20*1024*1024;
		MultipartRequest multi = new MultipartRequest(request,path,sizelimit, enctype,new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter( "name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureurl= multi.getFilesystemName("pictureurl");
		if(pictureurl==null) {
			pictureurl= multi.getParameter("nonmakeimg");
			System.out.println("여기로들어옴");
		}
		productvo pvo = new productvo();
		pvo.setCode(Integer.parseInt(code));
		pvo.setName(name);
		pvo.setPrice(price);
		pvo.setDescription(description);
		pvo.setPictureurl(pictureurl);
		
		productdao pdoa=productdao.getinstance();
		pdoa.updateproduct(pvo);
		
		response.sendRedirect("productlist.do");
	}

}
