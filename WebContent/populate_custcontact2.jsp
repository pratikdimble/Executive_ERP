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
<title>Sale Enquiry Form</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
<title>Populate Customer Contact page</title> 
</head> 
<body> 
			<div class="w3_agileits_main_grid w3l_main_grid" id="contact" >
							<span class="agileits_grid">
								<label>Contact</label>

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
				stmt=connection.prepareStatement("select mobile from erp_customer where custname LIKE ?"); 
			stmt.setString(1,  str+"%");
		//stmt=connection.prepareStatement("select mobile from erp_customer where custid=1"); 
			ResultSet rs=null; 
				rs= stmt.executeQuery(); 

						while(rs.next()){ 
%> 

<input type="text"  value="<%=rs.getLong("MOBILE")%>" name="contact" readonly  style="width: 130px;" /> 
<% 
} 
%> 
</span>
</div>
</body> 
</html> 