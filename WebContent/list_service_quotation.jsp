<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
 <!DOCTYPE html>
<html>
<head>
<title>Populate Quotation Table With Cost</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<!-- <link rel="stylesheet" type="text/css" href="css/menubar.css"/> -->
<!-- //custom-theme -->
<link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />

<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
  
<style>
#tabledata {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#tabledata td, #tabledata th {
    border: 1px solid #ddd;
    padding: 8px;
}

#tabledata tr:nth-child(even){background-color: #f2f2f2;}

#tabledata tr:hover {background-color: #ddd;}

#tabledata th {
/*     padding-top: 5px; */
/*     padding-bottom: 12px; */
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>

<body  >
 <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<!--       <a  ><input type="submit" name="operation" value="Back"/></a> -->

<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a href="salesmanagerfirstpage.jsp">Back</a>
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
<form action="./sale" method="POST">
<% 
String str=request.getParameter("q");
String prodname=null,company=null,custname=null,provider=null,sername=null;
//i=Integer.parseInt(str); 
int id=0,quantity=0;
float pcost=0,sercost=0,sid=0;
try { 
Class.forName("oracle.jdbc.OracleDriver"); 
} catch (ClassNotFoundException e) { 
e.printStackTrace(); 
return; 
} 
Connection connection = null; 
try { 
connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle"); 
} 
catch (SQLException e) { 
e.printStackTrace(); 
return; 
} 
	PreparedStatement stmt=null;
	ResultSet rs=null; 
	stmt=connection.prepareStatement("select * from erp_salequotation where custreq LIKE ?"); 	
			stmt.setString(1,"Service%");
				rs= stmt.executeQuery(); 
				if(rs.isBeforeFirst())
				{
	%>
	<div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid"> 
		<table id="tabledata">
   <tr>
	<th>Quotation ID</th>
	<th>Employee Name</th>
	<th>Customer Name</th>
   <th>Service Name</th>
   <th>Provider</th>
   <th>Service Cost</th>
   <th>Net Amount</th>
   <th>Service Tax</th>
   <th>Gross Net Amount</th>
   <th>Discount</th>
   <th>Grand Amount</th>
  </tr>
	<%
	stmt=connection.prepareStatement("select * from erp_salequotation where custreq LIKE ?"); 	
			stmt.setString(1,"Service%");
				rs= stmt.executeQuery(); 
				while(rs.next())
				{
				%>
 <tr >
     <h1 style="color:red">
     <td><input type="radio" name="choice"  onclick="document.getElementById('delete').removeAttribute('disabled');"><%=rs.getInt("id")%></input></td>
   	   	<td><%=rs.getString("custName")%></td>
   	   	<td><%=rs.getString("empName")%></td>
   	   	<td><%=rs.getString("serName")%></td>
   		 <td><%=rs.getString("provider")%></td>
   		  <td><%= rs.getFloat("sercost")%></td>
   		 <td><%=rs.getFloat("seramount") %></td>
   		 <td><%=rs.getFloat("sertax") %></td>
   		 <td><%=rs.getFloat("sergross") %></td>
   		 <td><%=rs.getFloat("serdiscount") %></td>
   		 <td><%=rs.getFloat("sergrand") %></td>
   		 </h1>
   		</tr>
  </table>
 <%
 } %>
	</span><div class="clear"></div>
						</div>
						<input type="submit" name="operation" id="delete" value="Delete" style="height: 40px; " disabled="disabled"/>
		<%
		 }//if----main

 else
 {
 %>
		<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">No Data Found</h1>
				<div class="w3layouts_main_grid">
				</div>
				</div>
				</div>
 <%
 }
		 %>
		</form>
      </body>
 </html>   
    
   
