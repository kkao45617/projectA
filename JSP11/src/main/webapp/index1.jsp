<%@page import="util.dbmanager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.do");
dispatcher.forward(request, response);
%>