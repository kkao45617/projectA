package com.springbook.diz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.springbook.biz.board.boardVO;
import com.springbook.diz.common.JDBCutil;


@Repository("boardDAO")
public class boardDAO {
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs= null;
	
	private final String board_inster="insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String board_update="update board set title=? content =? where seq=?";
	private final String board_get = "select * from board where seq=?";
	private final String board_list ="select * from board order by seq desc";
	private final String board_delete = "delete board where seq=?";
	
	//湲��벑濡�
	public void insertboard(boardVO vo) {
		System.out.println("====jdbc 濡� insert 湲곕뒫 泥섎━===");
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_inster);
			stmt.setInt(1, vo.getSeq());
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(stmt, conn);
		}
	}
	
	//湲� �닔�젙
	public void updateboard(boardVO vo) {
		System.out.println("=====jdbc update 湲곕뒫 泥섎━=====");
		boardVO board=null;
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_get);
			stmt.setInt(1, vo.getSeq());
			
			if(rs.next()) {
				board= new boardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs, stmt, conn);
		}
	}
	
	//湲� 紐⑸줉 議고쉶
	public List<boardVO> getboardlist(boardVO vo){
		System.out.println("========jdbc list 湲곕뒫泥섎━========");
		List<boardVO> boardlist = new ArrayList<boardVO>();
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_list);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				boardVO board = new boardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardlist.add(board);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs, stmt, conn);
		}
		return boardlist;
	}
	
	//湲��궘�젣
	public void deleteboard(boardVO vo) {
		System.out.println("=====jdbc delete 湲곕뒫泥섎━====");
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_delete);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	//湲� �긽�꽭議고쉶
	public boardVO getboard(boardVO vo) {
		System.out.println("====jdbc getboard 湲곕뒫泥섎━====");
		boardVO board = null;
		try {
			conn=JDBCutil.getConnection();
			stmt= conn.prepareStatement(board_get);
			stmt.executeQuery();
			if(rs.next()) {
				board=new boardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs, stmt, conn);
		}
		return board;
		
	}
	
	
	
	
}
