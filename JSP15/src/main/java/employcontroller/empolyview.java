package employcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employDAO.empolyDAO;
import employeesVO.employeesVO;

public class empolyview implements empoly {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="employ/employview.jsp";
		
		String id=request.getParameter("id");
		empolyDAO dao= empolyDAO.getinstance();
		
		employeesVO vo=dao.selectemployveiw(id);
		request.setAttribute("selectview", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
