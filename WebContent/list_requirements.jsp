<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<style>

.button {
  background-color: #f4511e;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
}

.button:hover {opacity: 1}


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
    <%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 	%>
                 	 <a class="active" href="hr_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Admin"))
                 	{
                 		%>
                 	 <a class="active" href="firstpage.jsp">Home</a>
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
<form action="./custreq" method="POST">
	<table id="customers">
<c:choose>
    <c:when test="${!empty listRequirementDTOs}">
   <tr>
	<th>Enquiry ID</th>
	<th>Customer Name</th>
    <th>Product Name</th>
    <th>Product Type</th>
    
   	<th>Company</th>
   	<th>Quantity</th>
   	<th>Status</th>
<!--    	<th>Operation</th> -->
  </tr>
    <c:forEach var="dto"  items="${listRequirementDTOs}">
    
     <tr>
     <h1 style="color:red">
   		<td>${dto.reqId}</td>
   		 <td>${dto.custName}</td>
   		 <td>${dto.prodName}</td>
   		 <td>${dto.prodType}</td>
   		 <td>${dto.prodCompany}</td>
   		 <td>${dto.quantity}</td>
   		 <td>${dto.status}</td>
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
<button class="button" id="myid" type="submit" name="operation" value="Approve" disabled>Approve</button>
<button class="button" id="myreject" type="submit" name="operation" value="Reject" disabled>Reject</button>
</form>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
      </body>
 </html>   
    
    
