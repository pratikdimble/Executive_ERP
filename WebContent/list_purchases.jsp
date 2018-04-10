<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <!DOCTYPE html>
<html>
<head>
<title>List all The Purchase Enquiries</title>
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
                
                 	else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Back</a>
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
  <c:when test="${!empty listpurchaseDTOs}">
   <tr>
	<th>Enquiry ID</th>
    <th>Supplier Name</th>
   <th>Address</th>
   <th>Contact</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>

  </tr>
    <c:forEach var="dto"  items="${listpurchaseDTOs}">
    
     <tr>
     <h1 style="color:red">
   		 <td>${dto.enqId}</td>
   		 <td>${dto.suppName}</td>
   		 <td>${dto.addr}</td>
   		 <td>${dto.contact}</td>
   		 <td>${dto.prodName}</td>
   		 <td>${dto.prodType}</td>
   		 <td>${dto.company}</td>
   		 <td>${dto.quantity}</td>
   		 <td>${dto.prodCost}</td>
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>

      </body>
 </html>   
    
    
