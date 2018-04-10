<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*"%> 
<%@ page import="java.sql.*"%> 
<%!int i;%> 
<%	try { 
		Class.forName("oracle.jdbc.OracleDriver"); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		return; 
		} 
	Connection connection = null; 
		try { 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle"); 
			} 
				catch (SQLException e1) { 
				e1.printStackTrace(); 
				return; 
			} 
	PreparedStatement stmt=null; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Area Page</title> 
</head> 
<body> 
<select style="width: 143px; height: 30px"> 
<option>Select Area</option> 
<% 
String str=request.getParameter("q"); 
i=Integer.parseInt(str); 
stmt=connection.prepareStatement("select * from erp_area where unid='"+i+"'");
			ResultSet rs=null; 
			rs= stmt.executeQuery(); 
while(rs.next()){ 
%> 
<option  value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option> 
<% 
} 
%> 
</select> 
</body> 
</html> 