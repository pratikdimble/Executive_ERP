<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body >
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a class="active" href="prod_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 		%>
                 	 <a class="active" href="hr_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 		else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a class="active" href="purchase_manager_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a class="active" href="service_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a class="active" href="prod_manager_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a class="active" href="salesmanagerfirstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a class="active" href="service_manager_firstpage.jsp">Home</a>
                 	 <% 
						}
                 	else
                 	{
                 				%>
                 	 <a class="active" href="index.jsp">Home</a>
                 	 <% 
                 	} 
%>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
   </div>
  
 <h2 style="color:red">Internal Problem</h2>
 <hr>
 ${errMsg}
 </body>
</html>