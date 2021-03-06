<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <!DOCTYPE html>
<html>
<head>
<title>Load the All Product Quotation</title>
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
  <%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Admin"))
                 	{
                 	%>
                 	 <a href="firstpage.jsp">Back</a>
                 	 <% 
                 	}
                
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
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
	<table id="customers">
<c:choose>
  <c:when test="${!empty listsaleDTOs}">
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
    <c:forEach var="dto"  items="${listsaleDTOs}">
    
     <tr>
     <h1 style="color:red">
   		 <td><input type="radio" name="choice"  onclick="document.getElementById('delete').removeAttribute('disabled');" value="${dto.id}">${dto.id}</input></td>
   		 <td>${dto.empName}</td>
   		 <td>${dto.custName}</td>
   		 <td>${dto.serName}</td>
   		 <td>${dto.provider}</td>
   		 <td>${dto.sercost}</td>
   		 <td>${dto.serAmount}</td>
   		 <td>${dto.serTax}</td>
   		 <td>${dto.serGross}</td>
   		 <td>${dto.serDiscount}</td>
   		 <td>${dto.serGrand}</td>
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
<input type="submit" name="operation" id="delete" value="Delete Quotation" style="height: 40px; " disabled="disabled"/>
     	 </form>
	</body>
 </html>   
    
    
