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
<title>Populate Service Cost page</title> 
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
				<div class="w3_agileits_main_grid w3l_main_grid" id="servicecost" >
							<span class="agileits_grid">
								<label>Service Cost</label>
<% 
String provider=request.getParameter("q"); 
String service=request.getParameter("r"); 
//i=Integer.parseInt(str); 
int id=0;
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
	stmt=connection.prepareStatement("select servicecost from erp_servicedata where name='"+service+"' and provider like ?");
		stmt.setString(1,  provider+"%");
		rs= stmt.executeQuery(); 
			while(rs.next())
				{
					 cost=rs.getFloat("servicecost");
				} 
		%> 
			<input type="text" name="servicecost" value="<%=cost%>" readonly style="width: 130px;">
				</span><div class="clear"/>
			</div>
			
			<input type="hidden" id="mysercost" value="<%=cost%>" readonly style="width: 130px;">
	</body> 
</html> 