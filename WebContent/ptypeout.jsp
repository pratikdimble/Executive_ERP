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
<link rel="stylesheet" href="css/style5.css" type="text/css" media="all" /><!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Expletus+Sans" rel="stylesheet">
<title>Product Type Page</title> 
</head> 
<body> 
			<div class="agile-username">
				<p>Product Name</p>
				<span><i class="fa fa-trademark" aria-hidden="true"></i></span>
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
	PreparedStatement stmt=null,st=null; 
		stmt=connection.prepareStatement("select prodid from erp_product where name='"+str+"'"); 
		
			ResultSet rs=null,rs1=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
						i=rs.getInt(1);
						}
		st=connection.prepareStatement("select * from erp_product where prodid='"+i+"'"); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
		%> 
		<input type="text" name="prodtype" required="required" value="<%=rs1.getString("TYPE")%>"/><br>
		<% 
	} 
		%>				<div class="clear"></div>
			</div> 
<!-- </select>  -->
</body> 
</html> 