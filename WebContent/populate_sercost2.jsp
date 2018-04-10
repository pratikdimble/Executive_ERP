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
<link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />
</head> 
<body> 
<div class="w3_agileits_main_grid w3l_main_grid" id="seramt"  >
<span class="agileits_grid"></span>
								<label>Net Amount </label>

<% 
String str=request.getParameter("q"); 
/* Integer i = null;
try {
    i = Integer.valueOf("str");
} catch (NumberFormatException nfe) {
    // Deal with the error
} */
String sername=null,provider=null;
int i=Integer.parseInt(str); 
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
	stmt=connection.prepareStatement("select * from erp_sale where id="+i);
		rs= stmt.executeQuery(); 
			while(rs.next())
				{
					sername=rs.getString("serName");
					provider=rs.getString("provider");
				} 
	stmt=connection.prepareStatement("select servicecost from erp_servicedata where name='"+sername+"' and provider like ?");
		stmt.setString(1,  provider+"%");
		rs= stmt.executeQuery(); 
			while(rs.next())
				{
					 cost=rs.getFloat("servicecost");
				} 
		%> 
<input id="seramt"  type="text"  value="<%=cost %>"   readonly style="width: 130px;" >
								</div>	
								<input id="amt"  type="hidden" name="seramt" value="<%=cost %>"   readonly style="width: 130px;" >
	</body> 
</html> 