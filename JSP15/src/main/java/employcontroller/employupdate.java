package employcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employDAO.empolyDAO;
import employeesVO.employeesVO;

public class employupdate implements empoly {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesVO vo= new employeesVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(request.getParameter("gender"));
		vo.setPhone(request.getParameter("phone"));
		
		empolyDAO dao = empolyDAO.getinstance();
		dao.employupdate(vo);
		new empolylist().execute(request, response);
		
	}

}
