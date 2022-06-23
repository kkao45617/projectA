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
		String savepath="/imge";
		int sizelimit = 5*1024*1024;
		String enctype="utf-8";
		
		
		ServletContext context = request.getServletContext();
		String path= context.getRealPath(savepath);
		MultipartRequest multi = new MultipartRequest(request,path,sizelimit,enctype,new DefaultFileRenamePolicy());
		
	
		String photourl= multi.getFilesystemName("photourl");
		int price = Integer.parseInt(multi.getParameter("price"));
		String title = multi.getParameter("title");
		String explantion = multi.getParameter("explanation");
		String link= multi.getParameter("link");
		
		//sql에 쏠 변수를 가져오는 곳
		shoppingVO vo = new shoppingVO();
		
		vo.setPhotourl(photourl);
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setExplanation(explantion);
		
		
		shoppingDAO dao = shoppingDAO.getinstance();
		dao.insertshopping(vo);
		
		
		
		
		new shoppinglist().excute(request, response);
	}

}
