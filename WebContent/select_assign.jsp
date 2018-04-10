<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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

<body  >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<!--     <a class="active" href="prod_manager_firstpage.jsp">Home</a> -->
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
	<table id="customers">
<c:choose>
  <c:when test="${!empty listassignDTOs}">
   <tr>
	<th>Assignment ID</th>
    <th>Employee Name</th>
    <th>Designation</th>
    <th>Assignment Date</th>
   <th>Assignment Type</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Service Name</th>
   <th>Region Name</th>
   <th>Area Name</th>
  </tr>
    <c:forEach var="dto"  items="${listassignDTOs}">
    
     <tr>
     <h1 style="color:red">
   		 <td>${dto.id}</td>
   		 <td>${dto.empName}</td>
   		 <td>${dto.design}</td>
   		 <td>${dto.assignDate}</td>
   		 <td>${dto.statusType}</td>
   		 <td>${dto.prodName}</td>
   		 <td>${dto.prodType}</td>
   		 <td>${dto.serName}</td>
   		 <td>${dto.region}</td>
   		 <td>${dto.area}</td>
	
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
  <h1 style="color:green">${assignRemovalMsg}</h1>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
      </body>
 </html>   
    
    
