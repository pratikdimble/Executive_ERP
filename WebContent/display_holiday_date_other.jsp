<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<title>Display Holiday Date::Others</title>
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
<!--       <a  ><input type="submit" name="operation" value="Back"/></a> -->

<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 		%>
                 	 <a href="hr_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a href="salesmanagerfirstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a href="prod_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a href="service_manager_firstpage.jsp">Back</a>
                 	 <% 
						}
                 	else
                 	{
                 				%>
                 	 <a href="index.jsp">Home</a>
                 	 <% 
                 	} 
%>
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
	<center><h2 style="color:green">Select Date</h2>	</center>
	<%
		while(rs.next())
			{
				String name = rs.getString("HOLIDAYDATE");
	%>
	<font color="red" size="5">
		<input type="radio" name="choice" value="<%=name%>" onclick="document.getElementById('myid').removeAttribute('disabled')"><%=name%></input>
	</font>

		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input type="submit" name="operation" value="DETAILS"/>&nbsp&nbsp<a href="holiday?operation=link1"><button type="button" style="width: 81px; ">View All</button></a>
		</pre>
</form>

</body>
</html>