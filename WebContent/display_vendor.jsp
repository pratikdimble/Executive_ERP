<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar1.css"/>
<title>Display Product Executive:Product Manager</title>
<style> 
input[type=button], input[type=submit], input[type=reset] {
    background-color: #4CAF50;
    border: none;
    color: white;
    font-size: 20px;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 4px;
    cursor: pointer;
}
</style>
<style type="text/css">

#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body background="img/back.jpg" >
		
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="purchase_manager_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1=null;
	ResultSet rs = null,rs1=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select vendorname from erp_vendor";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

<form method="POST" action="./vendor">
	<center><h2 style="color:green">Select Vendor</h2>	</center>
	<%
		while(rs.next())
			{
				String name = rs.getString("vendorname");
	%>
	<font color="red" size="5">
		<input type="radio" name="choice" value="<%=name%>" onclick="document.getElementById('view').removeAttribute('disabled');document.getElementById('update').removeAttribute('disabled');document.getElementById('delete').removeAttribute('disabled');"><%=name%></input>
	</font>

		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input type="submit" name="operation" id="view" value="View"style="height: 40px; "disabled="disabled"/>&nbsp&nbsp<input type="submit" id="update"  name="operation" value="Update"style="height: 40px; " disabled="disabled"/>&nbsp&nbsp<input type="submit" name="operation" id="delete" value="Delete"style="height: 40px; " disabled="disabled"/>&nbsp&nbsp
		</pre>
</form>

</body>
</html>