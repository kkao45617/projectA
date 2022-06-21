package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.saeyan.dto.productvo;

import java.util.*;



import util.dbmanager;

public class productdao {
	private productdao() {
		
	}
	private static productdao instance = new productdao();
	
	public static productdao getinstance() {
		return instance;
	}
	public List<productvo> selectallproducts(){
		String sql ="select * from product order by code desc";
		List<productvo> list = new ArrayList<productvo>();
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				productvo pvo=new productvo();
				pvo.setCode(rs.getInt("code"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPictureurl(rs.getString("pictureurl"));
				pvo.setDescription(rs.getString("description"));
				list.add(pvo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt, rs);
			
		}
		return list;
	}
	public int insertproduct(productvo pvo) {
		int result=-1;
		String sql="insert into product values(product_seq.nextval,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setInt(2, pvo.getPrice());
			pstmt.setString(3, pvo.getPictureurl());
			pstmt.setString(4, pvo.getDescription());
			result= pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt);
		}
		
		return result;
	}
	public productvo selectproductbycode(String code) {
		productvo pvo = new productvo();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql = "select * from product where code=?";
		
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pvo.setCode(rs.getInt(1));
				pvo.setName(rs.getString(2));
				pvo.setPrice(rs.getInt(3));
				pvo.setPictureurl(rs.getString(4));
				pvo.setDescription(rs.getString(5));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt, rs);
		}
		
		
		return pvo;
	}
	public void updateproduct(productvo pvo) {
		String sql= "update product set name=?, price=?, pictureurl=?,description=? where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setInt(2, pvo.getPrice());
			pstmt.setString(3, pvo.getPictureurl());
			pstmt.setString(4, pvo.getDescription());
			pstmt.setInt(5, pvo.getCode());
			pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt);
		}
	}
	public void productdelete(productvo pvo) {
		String sql="DELETE FROM product WHERE code=?";
				Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dbmanager.getconnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getCode());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbmanager.closeconnection(conn, pstmt);
			
		}
	}

	
}
