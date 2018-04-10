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

<title>Service Provider Page</title> 
</head> 
<body> 
  <select id="provider" name="provider" style="width: 143px; height: 40px" required="required" onchange="showCost(this.value); document.getElementById('productdata').style.display='block';document.getElementById('prodamt').style.display='block';">
				<option disabled selected="selected" value="none">Select Provider</option>

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
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system","oracle"); 
		} 
		catch (SQLException e) { 
			e.printStackTrace(); 
			return; 
		} 
	PreparedStatement st=null; 
		
			ResultSet rs=null; 

		st=connection.prepareStatement("select * from erp_servicedata where name='"+str+"'"); 
			rs= st.executeQuery(); 
						while(rs.next()){ 
		%> 
			<option value="<%=rs.getString("PROVIDER")%>"><%=rs.getString("PROVIDER")%></option>
<%-- 		<input type="text" name="provider" required="required" value="<%=rs.getString("PROVIDER")%>"/><br> --%>
		<% 
	} 
		%> 
</select> 
</body> 
</html> 