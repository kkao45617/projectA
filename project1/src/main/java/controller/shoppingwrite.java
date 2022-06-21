package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import DAO.shoppingDAO;

public class shoppingwrite implements shopping {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="shopping/write_form.jsp";
		
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
	}

}
