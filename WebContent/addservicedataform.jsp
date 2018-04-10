<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<%@ page import="java.sql.*"%> 
<%@ page import = "java.io.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Data From</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="displayproduct.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>


		
	<form action="./service" method="POST">
	<font color="RED"><b>
<%! String serName;

int serId;
%>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erp_service where name=?";
		
		serName=request.getParameter("choice");


	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
		
			ps.setString(1, serName);	
			rs = ps.executeQuery();	
					
		if(rs.next())
		{ 
			serId=rs.getInt("SID");
		}
	rs.close();
	ps.close(); 
	}
		catch(SQLException sqe)
		{
			out.println(sqe);
		} 
	%>		
<pre>
 <input type="hidden" name="id" value="<%= serId %>"  readonly><br>
		Service Name	 :: <input type="text" name="name" value="<%= serName %>"  readonly><br>
   		Service Provider  	 :: <input type="text" name="provider"  required><br>
   		Service Cost 	 :: <input type="text" name="cost"  required><br>
  		 <input type="submit" name="operation" value="Add Data" >	 
  		   
	</font></b></pre>

</form>

</body>
</html>