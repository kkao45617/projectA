package shoppingservelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.shoppingDAO;
import controller.shopping;
import controller.shoppinglist;
import shoppingVO.shoppingVO;

public class shoppingdelete implements shopping {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shopping/shoppingmain.jsp";
		
		int no = Integer.parseInt(request.getParameter("no"));
		shoppingDAO dao = shoppingDAO.getinstance();
		dao.delete(no);
		
		new shoppinglist().excute(request, response);
		
	}

}
