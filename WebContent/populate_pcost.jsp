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
<title>Populate Product Cost page</title> 
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
				<div class="w3_agileits_main_grid w3l_main_grid" id="productCost" >
				<span class="agileits_grid">
				<label>Product Cost</label>

<% 
String comp=request.getParameter("q"); 
String thisProduct = (String) session.getAttribute("prodname");
//i=Integer.parseInt(str); 
int id=0;
float cost=0;
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
			ResultSet rs=null;
		stmt=connection.prepareStatement("select cost from erp_productdata where name like ? and company like ?");
		//(select prodname from erp_sale where id="+id+") and company=(select company from erp_sale where id="+id+")"); 
		stmt.setString(1,  thisProduct+"%");
		stmt.setString(2,  comp+"%");
				rs= stmt.executeQuery(); 
				while(rs.next())
				{
				 cost=rs.getFloat("cost");
				} 
			//stmt.setString(1,  str+"%");
%> 
				<input id="prodCost"  type="text" name="prodcost" value="<%= cost  %>"  style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
</body> 
</html> 