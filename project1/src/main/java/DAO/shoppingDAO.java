package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import shoppingVO.shoppingVO;
import util.dbmanager;

public class shoppingDAO {
	private static shoppingDAO instance = new shoppingDAO();
	public static shoppingDAO getinstance() {
		return instance;
	}
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
	
}
