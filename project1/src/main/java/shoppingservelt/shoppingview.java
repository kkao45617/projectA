package shoppingservelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.shoppingDAO;
import controller.shopping;
import shoppingVO.shoppingVO;

public class shoppingview implements shopping {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="shopping/view.jsp";
		
		int no = Integer.parseInt(request.getParameter("no"));
		shoppingDAO dao = shoppingDAO.getinstance();
		shoppingVO vo = shoppingDAO.selectview(no);
		
		request.setAttribute("view", vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
