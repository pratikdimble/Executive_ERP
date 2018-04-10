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
<title>Populate Net Amount page</title> 
<link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
<div class="w3_agileits_main_grid w3l_main_grid" id="prodamt"  >
	<span class="agileits_grid"></span>
		<font color="white">
			<label>Net Amount </label>

<% 
String str=request.getParameter("q"); 

String prodname=null,company=null;
int i=Integer.parseInt(str); 
int id=0,quantity=0;
float cost=0;
	try { 
			Class.forName("oracle.jdbc.OracleDriver"); 
		} 
			catch (ClassNotFoundException e) { 
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
	stmt=connection.prepareStatement("select * from erp_sale where id="+i);
		rs= stmt.executeQuery(); 
			while(rs.next())
				{
					prodname=rs.getString("prodName");
					company=rs.getString("company");
					quantity=rs.getInt("QUANTITY");
				} 
	stmt=connection.prepareStatement("select cost from erp_productdata where name='"+prodname+"' and Company like ?");
		stmt.setString(1,  company+"%");
		rs= stmt.executeQuery(); 
			while(rs.next())
				{
					 cost=rs.getFloat("cost");
				} 
				
		%> 
<input id="totalamt"  type="text"  value="<%=cost * quantity  %>"   readonly style="width: 130px;" >Rs.
								</div>	
								<input id="totalamt"  type="hidden" name="total" value="<%=cost * quantity %>"   readonly style="width: 130px;" >
	</body> 
</html> 