*데이터베이스와 연결을 위해
tomcat->server->context.xml

*데이터베이스 연결 주소 참고
https://yooloo.tistory.com/171
---------------------------------
<Resource name="jdbc/mysql"
        auth="Container"
        type="javax.sql.DataSource"
        username="root"
        password="1234"
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/mydb" 
        maxActive="15"
        maxIdle="3"/>
---------------------------------------넣기       
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "javax.sql.*"%>
<%@ page import = "javax.naming.*"%>
<%
    Connection conn=null;

    Context init = new InitialContext();
    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
    conn = ds.getConnection();
    out.println(conn);
    conn.close();
%>
-----------------------------------확인하는 코드 jsp에 등록 
*테이블구조
create table shopping(no int(50) primary key, photourl varchar(500),
title varchar(500),Price int,Explanation varchar(400) ,date date);


*테이블 구성
등록 순서 ,사진url ,제목 ,금액 ,내용 ,등록날짜





