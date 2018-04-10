<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<%@ page import="java.sql.*"%> 
<%@ page import = "java.io.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Data Form</title>
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


		
	<form action="./controller" method="POST">
	<font color="RED"><b>
<%! String prodName,prodType;

int prodId;
%>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erp_product where name=?";
		
		prodName=request.getParameter("choice");


	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
		
			ps.setString(1, prodName);	
			rs = ps.executeQuery();	
					
		if(rs.next())
		{ 
			prodType= rs.getString("TYPE");
			prodId=rs.getInt("PRODID");
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
 <input type="hidden" name="id" value="<%= prodId %>"  readonly><br>
		Product Name	 :: <input type="text" name="name" value="<%= prodName %>"  readonly><br>
   		Product Type	 :: <input type="text" name="type" readonly  value="<%= prodType %>"><br>
   		Company Name   	 :: <input type="text" name="company"  required><br>
   		Product Cost 	 :: <input type="text" name="cost"  required><br>
   		Product Quantity :: <input type="text" name="quantity"  required><br>
   		Product Warranty :: <input type="text" name="warranty"  required><br>
  		 <input type="submit" name="operation" value="Add Data" >	 
  		   
	</font></b></pre>

</form>

</body>
</html>