*�����ͺ��̽��� ������ ����
tomcat->server->context.xml

*�����ͺ��̽� ���� �ּ� ����
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
---------------------------------------�ֱ�       
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
-----------------------------------Ȯ���ϴ� �ڵ� jsp�� ��� 
*���̺���
create table shopping(no int(50) primary key, photourl varchar(500),
title varchar(500),Price int,Explanation varchar(400) ,date date);


*���̺� ����
��� ���� ,����url ,���� ,�ݾ� ,���� ,��ϳ�¥





