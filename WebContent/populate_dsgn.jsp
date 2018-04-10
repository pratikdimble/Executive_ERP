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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Populate Designation page</title> 
</head> 
<body> 


<% 
String str=request.getParameter("q"); 
//i=Integer.parseInt(str); 
try { 
Class.forName("oracle.jdbc.OracleDriver"); 
} catch (ClassNotFoundException e) { 
e.printStackTrace(); 
return; 
} 
Connection connection = null; 
try { 
connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle"); 
} 
catch (SQLException e) { 
e.printStackTrace(); 
return; 
} 
	PreparedStatement stmt=null; 
		stmt=connection.prepareStatement("select designation from erp_employee where empname='"+str+"'"); 
		
			ResultSet rs=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
%> 
 <label>Designation</label>
<input type="text"  value="<%=rs.getString("Designation")%>" name="dsgn" readonly="readonly" style="width: 143px; height: 30px"/> 
<% 
} 
%> 

</body> 
</html> 