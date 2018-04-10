<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
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

<body  >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="searchproductform.html">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String name =request.getParameter("choice");
String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;



try{ 
connection = DriverManager.getConnection(url, user, dbpsw);
statement=connection.createStatement();
String sql ="SELECT * FROM ERP_PRODUCT WHERE NAME="+name;

resultSet = statement.executeQuery(sql);
if(!resultSet.next())
{
%>
<h2><center><font color="#FF0000" size="6">RECORD NOT FOUND...</font></center></h2>
<%
}else
{
%>
<table id="customers">
   <tr>
	<th>Product ID</th>
    <th>Product Name</th>
    <th>Product Type</th>
    <th>Product Company</th>
    <th>Product Cost</th>
    <th>Product Quantity</th>
    <th>Product Warranty</th>

</tr>
<% 
do{
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("PID") %></td>
<td><%=resultSet.getString("NAME") %></td>
<td><%=resultSet.getString("TYPE") %></td>
<td><%=resultSet.getString("COMPANY")%></td>
<td><%=resultSet.getString("COST")%></td>
<td><%=resultSet.getString("QUANTITY")%></td>
<td><%=resultSet.getString("WARRANTY")%></td>
</tr>
</table>
<% 
}while(resultSet.next());
}
} catch (Exception e) {
e.printStackTrace();
}
%>


      </body>
 </html>   
    
    
