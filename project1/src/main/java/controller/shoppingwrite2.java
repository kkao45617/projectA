package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.shoppingDAO;
import shoppingVO.shoppingVO;

public class shoppingwrite2 implements shopping {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//이미지 등록하는 곳
		
		
		
		//sql에 쏠 변수를 가져오는 곳
		shoppingVO vo = new shoppingVO();
		String url = "shopping/shoppingmain.jsp";
		
		vo.setPhotourl(request.getParameter("photourl"));
		vo.setTitle(request.getParameter("title"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setExplanation(request.getParameter("explanation"));
		
		
		shoppingDAO dao = shoppingDAO.getinstance();
		dao.insertshopping(vo);
		
		new shoppinglist().excute(request, response);
	}

}
