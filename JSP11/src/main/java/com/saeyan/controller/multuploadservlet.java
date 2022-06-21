package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class multuploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		
		String savepath="uploadfile";
		int uploadfilesizelimit=5*1024*1024;
		String enctype ="utf-8";
		
		ServletContext context = getServletContext();
		String uploadfilepath = context.getRealPath(savepath);
		System.out.println("�������� ���� ���丮");
		System.out.println(uploadfilepath);
		System.out.println("context->"+context.getContextPath());
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadfilepath,uploadfilesizelimit,enctype,new DefaultFileRenamePolicy());
			String filename = multi.getFilesystemName("uploadfile");
			if(filename==null) {
				System.out.println("���� ���ε� ���� �ʾ���");
			}else {
				out.print("<br>�۾���:"+multi.getParameter("name"));
				out.print("<br>����:"+multi.getParameter("title"));
				out.print("<br>���ϸ�:"+filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
