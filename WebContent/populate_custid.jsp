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
<title>Populate ID page</title>
<link rel="stylesheet" href="css/style5.css" type="text/css" media="all" /><!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Expletus+Sans" rel="stylesheet"> 
</head> 
<body> 

</div>
<div class="agile-username" id="custid">
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
	PreparedStatement stmt=null,st=null; 
		stmt=connection.prepareStatement("select custid from erp_customer where custname LIKE ?"); 
		stmt.setString(1,  str+"%");
			ResultSet rs=null,rs1=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
						i=rs.getInt(1);
						}
		st=connection.prepareStatement("select * from erp_customer where custid="+i+""); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
%> 

<input  type="hidden"  value="<%=rs1.getInt("CUSTID")%>" name="custid" readonly="readonly" style="width: 143px; height: 10px"></input> 
<% 
} 
%> 
		<div class="clear"></div>
			</div>
</body> 
</html> 