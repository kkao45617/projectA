package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.shoppingDAO;
import shoppingVO.shoppingVO;

public class shoppinglist implements shopping {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="shopping/shoppingmain.jsp";
		shoppingDAO dao = shoppingDAO.getinstance();

		List<shoppingVO> vo = dao.selectallempoly();
		request.setAttribute("shoppinglist", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
