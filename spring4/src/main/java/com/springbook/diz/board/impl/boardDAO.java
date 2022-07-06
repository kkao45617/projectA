package com.springbook.diz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.diz.board.boardVO;
import com.springbook.diz.common.JDBCutil;


@Repository("boardDAO")
public class boardDAO {
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs= null;
	
	private final String board_inster="insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String board_update="update board set title=?,content =?  where seq=?";
	private final String board_get = "select * from board where seq=?";
	private final String board_list ="select * from board order by seq desc";
	private final String board_delete = "delete board where seq=?";
	private final String board_list_t= "select * from board where title like '%'||?||'%' order by seq desc";
	private final String board_list_c="select * from board where content like '%'||?||'%' order by seq desc";
	
	//글등록
	public void insertboard(boardVO vo) {
		System.out.println("====jdbc 로 insert 기능 처리===");
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_inster);
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
	
	//글 수정
	public void updateboard(boardVO vo) {
		System.out.println("=====jdbc update 기능 처리=====");
		boardVO board=null;
		try {
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(board_update);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs, stmt, conn);
		}
	}
	
	//글 목록 조회
	public List<boardVO> getboardlist(boardVO vo){
		System.out.println("========jdbc list 기능처리========");
		List<boardVO> boardlist = new ArrayList<boardVO>();
		try {
			conn=JDBCutil.getConnection();
			if(vo.getSerchcondition().equals("title")) {
				stmt=conn.prepareStatement(board_list_t);
			}else if(vo.getSerchcondition().equals("content")) {
				stmt=conn.prepareStatement(board_list_c);
			}
			stmt.setString(1, vo.getSerchkeyword());
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
	
	//글삭제
	public void deleteboard(boardVO vo) {
		System.out.println("=====jdbc delete 기능처리====");
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
	
	//글 상세조회
	public boardVO getboard(boardVO vo) {
		System.out.println("====jdbc getboard 기능처리====");
		boardVO board = null;
		try {
			conn=JDBCutil.getConnection();
			stmt= conn.prepareStatement(board_get);
			stmt.setInt(1, vo.getSeq());
			rs=stmt.executeQuery();
			
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
