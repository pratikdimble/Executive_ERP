<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<title>Home</title>
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
    <a class="active" href="firstpage.jsp">Home</a>
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

String sql = "select name from erp_service";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

<form method="POST" action="./service">
	<center><h2 style="color:green">Select Service</h2>	</center>
	<%
		while(rs.next())
			{
				String name = rs.getString("name");
	%>
	<font color="red" size="5">
		<input type="radio" name="choice" value="<%=name%>"onclick="document.getElementById('myid1').removeAttribute('disabled');document.getElementById('myid2').removeAttribute('disabled')"><%=name%></input>
	</font>

		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input disabled id="myid2" type="submit" name="operation" value="Details"/>&nbsp&nbsp<input id="myid1" disabled type="submit" value="Add Details" formaction="addservicedataform.jsp" formmethod="post"/>&nbsp&nbsp<a href="addserviceform.html"><input type="button" value="ADD"/></a>&nbsp&nbsp
		</pre>
</form>

</body>
</html>