<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/submitbutton.css"/>
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<style type="text/css">
select { font-size:20px; }



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
		<font color="WHITE">
<div class="header">
		 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
    <a href="selectprodform.jsp">Back</a>
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

String sql = "select name from erp_product";



	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

<form method="post" action="selectprod.jsp">
	<center><h2 style="color:green">SELECT PRODUCT</h2>
	<table border="1" align="center" style="height: 226px; width: 664px">
			
			<tr>
			
				<td><font size="6" color="red">Select Product</font></td>
				<td>
					<select name="name" style="width: 365px; height: 115px" >
				<option value="select" >Select</option>
	<%
		while(rs.next())
			{
				String name = rs.getString("name");
	%>
			<option value="<%=name%>"><%=name%></option>
		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>
			</select>
			</td>
		</tr>
	</table>
	</center>
	<pre>&nbsp&nbsp<font size="8"></font><button type="submit" class="button" value="Select" width="100" style="width: 190px; height: 59px ">Search</button></font></pre>
</form>
</body>
</html>