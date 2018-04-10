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
<title>Populate Provider Page</title>
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
<div class="w3_agileits_main_grid w3l_main_grid" id="provider" >
			<span class="agileits_grid">
				<label>Service Provider</label>
				  <select name="provider" style="width: 143px; height: 40px" onchange="showSCost(this.value);">
				<option disabled selected="selected" value="none">Select Provider</option>
			</div>
<% 
String str=request.getParameter("q"); 
session.setAttribute("servicename",str);

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
		stmt=connection.prepareStatement("select provider from erp_servicedata where name=?"); 
		stmt.setString(1,str);
			ResultSet rs=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
%> 
<option  value=<%=rs.getString("provider")%>><%=rs.getString("provider")%></option>
<% 
} 
%> 
				</select>
			</span><div class="clear"/>
		</div>

</body> 
</html> 