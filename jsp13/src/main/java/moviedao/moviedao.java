package moviedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.dbmanager;
import movievo.moviedvo;

public class moviedao {
	private moviedao() {
		
	}
	private static moviedao instance = new moviedao();
	
	public static moviedao getinstance() {
		return instance;
	}

	public List<moviedvo> selectall() {
		String sql= "select * from movie order by code desc";
		List<moviedvo> mov = new ArrayList<moviedvo>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
	
		
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
		
		
			while(rs.next()) {
				moviedvo mvo= new moviedvo();
				
				mvo.setCode(rs.getInt("code"));
				mvo.setTitle(rs.getString("title"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActor(rs.getString("actor"));
				mvo.setPoster(rs.getString("poster"));
				mvo.setSynopsis(rs.getString("synopsis"));
				mov.add(mvo);
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt, rs);
		}
		System.out.println(mov);
		return mov;
	}
}
