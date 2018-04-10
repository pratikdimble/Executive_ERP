<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*"%> 
<%@ page import="java.sql.*"%> 
<%@ include file="JavaScript.jsp" %>
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
		<p>Product Company</p>
				<span><i class="fa fa-registered" aria-hidden="true"></i></span>
				  <select id="prodcomp" name="company" style="width: 143px; height: 40px" required="required" onfocus="showStock(this.value);" onchange="showStock(this.value);">
<option disabled selected="selected" value="none">Select Company</option>
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
		stmt=connection.prepareStatement("select pid from erp_productdata where name='"+str+"'"); 
		
			ResultSet rs=null,rs1=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
						i=rs.getInt(1);
						}
		st=connection.prepareStatement("select company from erp_productdata where name='"+str+"'"); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
		%> 
		<option value=<%=rs1.getString("company")%>><%=rs1.getString("company")%></option>
		<% 
	} 
		%>				</select>
				<div class="clear"></div>
			</div>
			
<!-- </select>  -->
</body> 
</html> 