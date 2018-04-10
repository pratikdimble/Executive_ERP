<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.sql.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<style>


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
<title>Service Executive:: To Do List</title>
<body  >
<%! String empName,userName;
String userdbPsw,userPsw;
String empDesg,userRole;
int userId;
%>
<%

Connection con= null;
	PreparedStatement ps = null,ps1= null,ps2= null;
	ResultSet rs = null,rs1= null,rs2= null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";
		String name = (String) session.getAttribute("name");
		String login_sql= "select id from erp_login where name=?";
		String emp_sql = "select EMPNAME from erp_employee where EMPID=?";
		String assign_sql = "SELECT * FROM ERP_EMPASSIGN  Where DESIGN='Service Executive' and  EMPNAME=?";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(login_sql);ps1= con.prepareStatement(emp_sql);ps2= con.prepareStatement(assign_sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			//to get the login id
				while (rs.next()) {
						 userId=rs.getInt(1);
						}
						//to get the employee name
							ps1.setInt(1, userId);
					rs1 = ps1.executeQuery();	
					while (rs1.next()) {
						 empName=rs1.getString("empname");
						}
						//display the wotk list
					ps2.setString(1, empName);
					rs2 = ps2.executeQuery();	

	%>

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="service_exec_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
	<table id="customers">

   <tr>
   <th>Assignment ID</th>
    <th>Assignment Date</th>
   <th>Service Name</th>
   <th>Region Name</th>
   <th>Area Name</th>
  </tr>
    
     <tr><%
		while (rs2.next()) {
	%>
	<td><label value="<%=rs2.getString("ID")%>"><%=rs2.getString("ID")%></label></td>
	<td><label value="<%=rs2.getString("ASSIGNDATE")%>"><%=rs2.getString("ASSIGNDATE")%></label></td>
	<td><label value="<%=rs2.getString("SERNAME")%>"><%=rs2.getString("SERNAME")%></label></td>
	<td><label value="<%=rs2.getString("REGION")%>"><%=rs2.getString("REGION")%></label></td>
	<td><label value="<%=rs2.getString("AREA")%>"><%=rs2.getString("AREA")%></label></td>
		</tr>
		<% 
		}//while

		%>

 </table>
   <!--      <h1 style="color:red;text-align:center">You Dont Have Any Assignments</h1> -->
           		   				<%

	}//try
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>  
      </body>
 </html>   
    
    
