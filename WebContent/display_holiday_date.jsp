<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<title>Display Holiday Date::Admin</title>
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
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select HOLIDAYDATE from erp_holiday";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

<form method="POST" action="./holiday">
	<center><h2 style="color:green">Select Date</h2></center>
	<%
		while(rs.next())
			{
				String name = rs.getString("HOLIDAYDATE");
	%>
	<font color="red" size="5">
		<input type="radio" name="choice" value="<%=name%>" onclick="document.getElementById('myid').removeAttribute('disabled');document.getElementById('details').removeAttribute('disabled');document.getElementById('update').removeAttribute('disabled');"><%=name%></input>
	</font>

		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input type="submit" name="operation" value="DETAILS" id="details" disabled/>&nbsp&nbsp<a href="add_holiday_form.jsp"><input type="button" value="Insert" name="operation" style="height: 33px; "/></a>&nbsp&nbsp<input id="myid" type="submit" name="operation" value="DELETE" onClick="conf()" disabled/>&nbsp&nbsp<input type="submit" name="operation" value="UPDATE" id="update" disabled/>
		</pre>
</form>
<script type="text/javascript">
function conf()
{
var con=confirm("Do you want to Delete for sure?");
}
</script>
</body>
</html>