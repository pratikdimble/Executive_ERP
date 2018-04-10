
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
        <link rel="stylesheet" type="text/css" href="css/registrationdefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null;
	ResultSet rs = null,rs1 = null,rs2 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String custname = "select custname from erp_customer";
String areaname = "select areaname from erp_area";
String regname = "select regname from erp_region";



	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(custname);ps1 = con.prepareStatement(areaname);ps2 = con.prepareStatement(regname);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();  
	%>

		
	<form action="./custappoint" method="POST">
	<font color="RED" size="5"><b>
	<pre><br><hr>
Select Customer Name	  :: <select name="cust" style="width: 143px; height: 30px" required="required">
				<option >select</option>
	<%
		while(rs.next())
			{
				String cust = rs.getString("custname");
	%>
			<option value=<%=cust%>><%=cust%></option>
		<% 
		}
		%>
		</select><br>
Select Region Name	  :: <select name="reg" style="width: 143px; height: 23px" required="required">
				<option>select</option>
	<%
		while(rs2.next())
			{
				String reg = rs2.getString("regname");
	%>
			<option value=<%=reg%>><%=reg%></option>
		<% 
		}
		%>
		 </select>
		<br>
Appoint To	 	  :: <input type="text" name="to" style="width: 383px; height: 30px" required="required"/><br>
Appointment Type  	  ::  <input type="radio" name="type" checked="checked">To Call</input>		<input type="radio" name="type">To Visit</input><br>
Subject 	 	  :: <input type="text" name="subject" style="width: 143px; height: 30px" required="required"/><br>
Date	  	 	  :: <input type="date" name="date" style="width: 143px; height: 30px" required="required"/> 		Appointment Time	::  <input type="time" name="time" style="width: 143px; height: 30px" required="required"/><br>
Venue	 	 	  :: <input type="text" name="venue" style="width: 383px; height: 30px" required="required"/><br>
Contact No./EMail    	  :: <input type="text" name="contact" style="width: 383px; height: 30px" required="required"/><br>
   				<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>
  		 <input type="submit" name="operation" value="ADD">
	</pre></b></font>
</form>

</body>
</html>

		<%-- <br>
		Select Area Name	  :: <select name="area" style="width: 143px; height: 23px">
				<option value="select">select</option>
	<%
		while(rs1.next())
			{
				String area = rs1.getString("areaname");
	%>
			<option value=<%=area%>><%=area%></option>
		<% 
		}
		%>
		</select> --%>