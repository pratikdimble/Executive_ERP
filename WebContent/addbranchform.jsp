
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="bankandbranch.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select bankname from erp_bank";



	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

		
	<form action="./branch" method="POST">
	<font color="RED"><b>
	<pre>
   		Select Bank Name	  :: <select name="bank" style="width: 143px; height: 23px">
				<option value="select">select</option>
	<%
		while(rs.next())
			{
				String bank = rs.getString("bankname");
	%>
			<option value=<%=bank%>><%=bank%></option>
		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>
			</select><br>
		Branch Name	 	  :: <input type="text" name="brname"><br>
   		Description	 	  :: <input type="text" name="desc" style="width: 383px; "><br>
  		 <input type="submit" name="operation" value="ADD">
	</pre></b></font>
</form>

</body>
</html>