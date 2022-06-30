package com.springbook.view.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;
import com.springbook.diz.board.impl.boardDAOspring;
import com.springbook.diz.user.userVO;
import com.springbook.diz.user.impl.userDAO;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class dispatcherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private handermapping handlermapping;
    private viewresolver viewresolver;
 
    public void init() throws ServletException{
    	System.out.println("dispatcherserlet init()-----------------------");
    	handlermapping = new handermapping();
    	viewresolver = new viewresolver();
    	viewresolver.setPrefix("./");
    	viewresolver.setSuffix(".jsp");
    }
    
    public dispatcherservlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request,response);
	}

	private void Process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		
		String path = uri.substring(uri.lastIndexOf("/"));
		
		controller ctrl = handlermapping.getcontroller(path);
		
		String viewname = ctrl.handlerequest(request, response);
		
		String view = null;
		if(!viewname.contains(".do")) {
			view= viewresolver.getView(viewname);
		}else {
			view = viewname;
		}
		response.sendRedirect(view);
		
		
		
		
		
		/*request.setCharacterEncoding("utf-8");
		//1. 클라이언트의 요청 path정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri=====>"+uri+":" +path);
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			request.setCharacterEncoding("utf-8");

			String id = request.getParameter("id");
			String password = request.getParameter("password");
			userVO vo = new userVO();
			
			vo.setId(id);
			vo.setPassword(password);
			
			userDAO DAO = new userDAO();
			userVO user = DAO.getuser(vo);
			
			System.out.print(user);
			if(user !=null){
				response.sendRedirect("getboardlist.jsp");
				System.out.println("로그인에 들어왔음");
				
			}else {
				response.sendRedirect("login.jsp");
				System.out.print("안들오옴 들어옴");
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
		}else if(path.equals("/updateboard.do")) {
			System.out.println("글수정 처리");
			
			request.setCharacterEncoding("utf-8");
			String title= request.getParameter("title");
			String content= request.getParameter("content");
			String seq = request.getParameter("seq");
			System.out.print(seq);
			
			
			boardDAO DAO = new boardDAO();
			boardVO vo = new boardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			DAO.updateboard(vo);
			response.sendRedirect("getboardlist.jsp");
			
		}else if(path.equals("/insertboard.do")) {
			System.out.println("글등록 처리");
			
			request.setCharacterEncoding("utf-8");
			String title=  request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			boardDAO DAO = new boardDAO();
			boardVO vo = new boardVO();
			
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			DAO.insertboard(vo);
			response.sendRedirect("getboardlist.jsp");
			
		}else if(path.equals("/deleteboard.do")) {
			System.out.println("글삭제 처리");
			
			String seq=request.getParameter("seq");
			boardVO vo = new boardVO();
			vo.setSeq(Integer.parseInt(seq));
			boardDAO DAO= new boardDAO();
			DAO.deleteboard(vo);
			response.sendRedirect("getboardlist.jsp");
			
		}else if(path.equals("/getboard.do")) {
			System.out.println("글상세 조회 처리");
			
			String seq= request.getParameter("seq");
			boardVO vo=new boardVO();
			vo.setSeq(Integer.parseInt(seq));
			boardDAO DAO = new boardDAO();
			boardVO board = DAO.getboard(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			response.sendRedirect("getboard.jsp");
		}else if(path.equals("/getlistboard.do")) {
			System.out.println("글 목록 검색 처리");
			
			
			request.setCharacterEncoding("utf-8");
			boardVO vo = new boardVO();
			boardDAO dao = new boardDAO();
			List<boardVO> boardlist = dao.getboardlist(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardlist", boardlist);
			response.sendRedirect("old/getboardlist.jsp");
			
		}*/
		
	}
}
