<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 

<%@ page import="java.sql.*" %>
<%!int id;%> 
<%	try { 
		Class.forName("oracle.jdbc.OracleDriver"); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		return; 
		} 
	Connection connection = null; 
		try { 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
													 "system","oracle"); 
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

<% 
String str=request.getParameter("ename"); 
	id=Integer.parseInt(str); 
		stmt=connection.prepareStatement("select * from erp_employee where empid="+id); 
			ResultSet rs=null; 
			rs= stmt.executeQuery(); 
			while(rs.next()){ 
	%>
		<input type="text" name="popu" value="<%=rs.getString(2)%>">	</input>
	<% 
		} 
	%> 
	
</body> 
</html> 