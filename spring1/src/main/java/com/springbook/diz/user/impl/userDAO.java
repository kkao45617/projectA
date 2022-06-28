package com.springbook.diz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.diz.common.JDBCutil;
import com.springbook.diz.user.userVO;

@Repository("userdao")
public class userDAO {
	private Connection conn = null;
	private PreparedStatement stmt=null;
	private ResultSet rs= null;
	
	private final String user_get = "select * from users where id=? and password=?";
	
	public userVO getuser(userVO vo) {
		userVO user= null;
		try {
			System.out.println("=====jdbc getuser======");
			conn=JDBCutil.getConnection();
			stmt=conn.prepareStatement(user_get);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				user=new userVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs, stmt, conn);
		}
		return user;
	}
}
