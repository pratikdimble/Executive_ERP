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

<title>Product Type Page</title> 
</head> 
<body> 
			<div class="agile-username" id="productStock">

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
		st=connection.prepareStatement("select quantity from erp_productdata where company='"+str+"'"); 
			rs= st.executeQuery(); 
						while(rs.next()){ 
		%> 
		<input type="hidden" id="quan" name="quan"  value="<%=rs.getInt("quantity")%>"/><br>
		<% 
	} 
		%> 
						<div class="clear"></div>
			</div>
<!-- </select>  -->
</body> 
</html> 