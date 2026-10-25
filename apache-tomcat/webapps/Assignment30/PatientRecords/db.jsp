<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/hospitalDB";
String user = "root";
String password = "NewPass123";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url, user, password);
%>
     