package com.it.dao;

import java.util.*;  //List
import java.util.Date;
import java.sql.*;  //Connection.PrepdaedStatment, ResultSet


public class boarddao {
   private Connection conn=null;
   private PreparedStatement ps = null;
   
   private final String URL = "jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
   private final String USERNAME = "root";
   private final String PASSWORD = "1234";
   
   
   //드라이브 등록
   public boarddao() {
      try {
         
         Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 메모리 활당
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //MySql 연결
   public void getConnection() {
      try {
         
         conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //MySql해제
   public void disConnection() {
      try {
         if(ps != null) ps.close();
         if(conn != null) conn.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   //1. 목록출력
    // 게시물 정보 한개 : BoardVO, 게시물 여러개 : (List)
   public List<boardvo> boardListData(int page){
      List<boardvo> list = new ArrayList<boardvo>();
      
      try {
         
         //1. 연결
         getConnection();
         //2. SQL문장 작성
         int rowSize = 10;
         int start = (rowSize*page) - rowSize;  
         // 10*1 - 10 = 0,10 ..... 10*2-10=10,10, 10*3-10=20,10....
         String sql = "select no, subject, name, DATE_FORMAT(regdate, '%Y-%m-%d'), hit "  //여기 한칸
                  + "from jspboard order by no desc limit ?, ?";
         
         //3. 전송
         ps = conn.prepareStatement(sql);
         //4. 데이타 채우기
         ps.setInt(1, start);
         ps.setInt(2, rowSize);
         
         //5. 데이타 실행
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()) {
        	 boardvo vo = new boardvo();
            vo.setNo(rs.getInt(1));
            vo.setSubject(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setDbday(rs.getString(4));
            vo.setHit(rs.getInt(5));
            list.add(vo);
         }
         //6. 닫기
         rs.close();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         disConnection();
      }
      return list;
   }
   
   
   //2. 총페이지()
   public int boardTotalPage() {
      int total=0;
      
      try {
         
         getConnection();
         String sql = "select ceil(count(*)/10.0) from jspboard";
         
         ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()) {
            total = rs.getInt(1);
         }
         rs.close();
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         disConnection();
      }
      
      return total;
   }
   
   //3.insert(새글 입력)
   public void boardinsert(boardvo vo) {

	   
	   try {
		getConnection();
		String sql="insert into jspboard(name,subject,content,pwd,regdate) values(?,?,?,?,now())";
		ps=conn.prepareStatement(sql);
		ps.setString(1, vo.getName());
		ps.setString(2,vo.getSubject());
		ps.setString(3, vo.getContent());
		ps.setString(4, vo.getPwd());
		
		ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disConnection();
	}
   }
   
   //자세한 게시판 정보
   public boardvo boardetaildate(int no) {
	   boardvo vo = new boardvo();
	   try {
		
		   getConnection();
		   
		   //조회수 증가
		   String sql = "update jspboard set hit = hit+1 where no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.executeUpdate();
		   
		   
		   sql="select no,name,subject,content,date_format(regdate,'%Y-%m-%d'),hit"
		   +" from jspboard where no=? ";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs= ps.executeQuery();
		   if(rs.next()) {
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   vo.setDbday(rs.getString(5));
			   vo.setHit(rs.getInt(6));
			   rs.close();
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disConnection();
	}
	   
	   return vo;
   }
   
   //수정페이지
   public boardvo boardupdatedata(int no) {
	   boardvo vo = new boardvo();
	   try {
			
		   getConnection();
	
		   
		   String sql="select no,name,subject,content,date_format(regdate,'%Y-%m-%d'),hit"
		   +" from jspboard where no=? ";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs= ps.executeQuery();
		   if(rs.next()) {
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   vo.setDbday(rs.getString(5));
			   vo.setHit(rs.getInt(6));
			   rs.close();
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disConnection();
	}
	   
	   return vo;
   }
   
   public boolean boardupdate(boardvo vo) {
	      boolean check = false;
	      
	      try {
	         getConnection();
	         
	         String sql = "select pwd from jspBoard where no=?";
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, vo.getNo());
	         ResultSet rs = ps.executeQuery();
	         String check_pwd="";
	         
	         if(rs.next()) {
	            check_pwd = rs.getString(1);
	            
	            rs.close();
	         }
	         if(check_pwd.equals(vo.getPwd())) {
	            check = true;
	            sql = "update jspBoard set name=?, subject=?, content=? where no=?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, vo.getName());
	            ps.setString(2, vo.getSubject());
	            ps.setString(3, vo.getContent());
	            ps.setInt(4, vo.getNo());
	            ps.executeUpdate();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         disConnection();
	      }
	      return check;
	   }//boardUpdate
   
   public boolean boarddelete(int no,String pwd) {
	   boolean chk=false;

	   try {
			
		   getConnection();
	
		   
		   String sql="select pwd from jspboard where no=? ";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1,no);
		   String chk_pwd="";
		   ResultSet rs= ps.executeQuery();
		   if(rs.next()) {
			   chk_pwd= rs.getString(1);
			   rs.close();
		   }
		   if(chk_pwd.equals(pwd)) {
			   chk=true;
			   
			   sql="delete from jspboard where no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			 
			   
			   ps.executeUpdate();
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disConnection();
	}
	   
	   
	   return chk;
   }
  
 
}