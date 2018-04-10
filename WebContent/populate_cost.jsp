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
				<div class="w3_agileits_main_grid w3l_main_grid" id="costproduct" >
							<span class="agileits_grid">
								<label>Cost Per Product </label>
<% 
String comp=request.getParameter("q"); 
//String prod=request.getParameter("r"); 
String thisProduct = (String) session.getAttribute("myproduct");
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
		stmt=connection.prepareStatement("select cost from erp_productdata where name='"+thisProduct+"' and company='"+comp+"'");
		//(select prodname from erp_sale where id="+id+") and company=(select company from erp_sale where id="+id+")"); 
		
				rs= stmt.executeQuery(); 
				while(rs.next())
				{
				 cost=rs.getFloat("cost");
				} 
			//stmt.setString(1,  str+"%");
%> 
<input type="text" name="prodcost" value="<%= cost %>" readonly style="width: 130px;">

							</span><div class="clear"></div>
						</div>
						<input id="totalcost"  type="hidden"  value="<%=cost %>"   readonly style="width: 130px;" >
</body> 
</html> 