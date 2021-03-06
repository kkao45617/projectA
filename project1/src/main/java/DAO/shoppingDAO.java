package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import shoppingVO.shoppingVO;
import util.dbmanager;

public class shoppingDAO {
	private static shoppingDAO instance = new shoppingDAO();
	public static shoppingDAO getinstance() {
		return instance;
	}
	
	//상품 등록
	public void insertshopping(shoppingVO vo) {
		String sql = "insert into shopping values(null,?,?,?,?,now())";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPhotourl());
			pstmt.setString(2, vo.getTitle());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getExplanation());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt);
		}
	}
	
	//메인페이지 화면리스트
	public List<shoppingVO> selectallempoly() {
		List<shoppingVO> list = new ArrayList<shoppingVO>();
		String sql ="select * from shopping";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				shoppingVO vo = new shoppingVO();
				vo.setNo(rs.getInt(1));
				vo.setPhotourl(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setExplanation(rs.getString(5));
				vo.setDate(rs.getTimestamp(6));
				
				list.add(vo);
				
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt, rs);
		}
		
		
		
		return list;
	}

	public static shoppingVO selectview(int no) {
		String sql = "select * from shopping where no=?";
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		shoppingVO vo= new shoppingVO();
		try {
			conn = dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setPhotourl(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setExplanation(rs.getString(5));
				vo.setDate(rs.getTimestamp(6));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt, rs);
		}
		
		return vo;
	}

	public void delete(int no) {
		String sql = "delete from shopping where no=?";
		Connection conn= null;
		PreparedStatement pstmt= null;
		try {
			conn = dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt);
		}
	}
	
}
