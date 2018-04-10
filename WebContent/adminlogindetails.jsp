<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<body  >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="firstpage.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
	
 
</head>
<body>
<table id="customers">
   <tr>
	<th>User Name</th>
    <th>User Password</th>
    <th>User Role</th>
  </tr>
<%
String thisUser = (String) session.getAttribute("myUser");
String thisPass = (String) session.getAttribute("myPass");
String thisRole = (String) session.getAttribute("myRole");
%>
 
     <tr>
    
   		 <td><div><%= thisUser %></div></td>
   		 <td><div><%= thisPass %></div></td>
   		 <td><div><%= thisRole %></div></td>
   		
   		</tr>

 </table>

<%-- <div>The UserName is : <%= thisUser %></div>
<div>The Password is : <%= thisPass %></div>
<div>The User Role is: <%= thisRole %></div> --%>

</body>
</html>