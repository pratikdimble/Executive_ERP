<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<title>Display Payment Month</title>
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
<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a href="prod_manager_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a href="service_manager_firstpage.jsp">Home</a>
                 	 <% 
						}
						else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Home</a>
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
String thisUser = (String) session.getAttribute("empname");


String sql = "select salmonth from erp_paymentslip where empname='"+thisUser+"'";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.isBeforeFirst())
			{
			
	%>

<form method="POST" action="./paymentslip">
	<center><h2 style="color:green">Select Date</h2>	</center>
	<%
		while(rs.next())
			{
				String name = rs.getString("salmonth");
	%>
	<font color="red" size="5">
		<input type="radio" name="choice" value="<%=name%>" onclick="document.getElementById('myid').removeAttribute('disabled')"><%=name%></input>
	</font>

		<% 
		}
	
	%>
	<pre>&nbsp&nbsp<input type="submit" name="operation" value="View"/>
		</pre>
		<% 
	
	}else{
	%>
			<center><h2 style="color:green">No Records</h2>	</center>
			<%
				/*  */
	}		 
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		
</form>

</body>
</html>