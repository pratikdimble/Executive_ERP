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
<title>Populate Supplier Address page</title> 
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
				<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Address</label>

<% 
String str=request.getParameter("q"); 
session.setAttribute("supplier",str);
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
	PreparedStatement stmt=null; 	ResultSet rs=null;
		stmt=connection.prepareStatement("select VENDORNAME from erp_VENDOR where VENDORNAME like ?"); 
		stmt.setString(1,  str+"%");
				rs= stmt.executeQuery(); 
String name=null,city=null,addr=null;
						while(rs.next()){
						name=rs.getString("VENDORNAME");
						} 
				
stmt=connection.prepareStatement("select * from erp_VENDOR where VENDORNAME like ?");
stmt.setString(1,  name+"%"); 
rs= stmt.executeQuery(); 
						while(rs.next()){
						city=rs.getString("VENDORCITY");
						addr=rs.getString("VENDORADDR"); 
						}
%> 
<input type="text"  value="<%=addr+","+city%>" name="addr" readonly style="width: 200px;"/> 
							</span>
						</div>

</body> 
</html> 