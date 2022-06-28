package controller;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.shoppingDAO;
import shoppingVO.shoppingVO;

@WebServlet("/write.do")
public class shoppingwrite3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		ServletContext context = getServletContext();
		String enctype = "utf-8";
		int sizelimit = 20*1024*1024;
		String path = context.getRealPath("imge");
		
		
		MultipartRequest multi = new MultipartRequest(request, path,sizelimit,enctype,new DefaultFileRenamePolicy());
		
		String photourl = multi.getFilesystemName("photourl");
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String explanation = multi.getParameter("explanation");
		
		shoppingVO vo = new shoppingVO();
		vo.setExplanation(explanation);
		vo.setPrice(price);
		vo.setPhotourl(photourl);
		vo.setTitle(title);
		
		shoppingDAO DAO = new shoppingDAO();
		DAO.insertshopping(vo);
		
		String link="list";
		response.setHeader("link", link);
		new shoppinglist().excute(request, response);
	}

}
