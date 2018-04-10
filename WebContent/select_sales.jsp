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
<form action="./sale" method="POST">
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
	<table id="customers">
<c:choose>
  <c:when test="${!empty listsaleDTOs}">
   <tr>
	<th>Enquiry ID</th>
    <th>Employee Name</th>
    <th>Designation</th>
    <th>Customer Name</th>
   <th>Address</th>
   <th>Contact</th>
    <th>Requirement</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>
   <th>Service Name</th>
   <th>Service Provider</th>
   <th>Service Cost</th>
  </tr>
    <c:forEach var="dto"  items="${listsaleDTOs}">
    
     <tr>
     <h1 style="color:red">
     <td><input type="radio" name="choice" value="${dto.id}" onclick="document.getElementById('myid').removeAttribute('disabled');">${dto.id}</input></td>
<%--    		 <td>${dto.id}</td> --%>
   		 <td>${dto.empName}</td>
   		 <td>${dto.design}</td>
   		 <td>${dto.custName}</td>
   		 <td>${dto.addr}</td>
   		 <td>${dto.contact}</td>
   		 <td>${dto.custReq}</td>
   		 <td>${dto.prodName}</td>
   		 <td>${dto.prodType}</td>
   		 <td>${dto.company}</td>
   		 <td>${dto.quantity}</td>
   		 <td>${dto.prodCost}</td>
   		 <td>${dto.serName}</td>
   		 <td>${dto.provider}</td>
   		  <td>${dto.serCost}</td>
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
<pre>
<input id="myid" disabled type="submit" name="operation" value="Delete"  style="height: 40px; "/>&nbsp&nbsp<input formaction="sale_enquiry.jsp" type="submit" value="New Enquiry" style="height: 40px; "/>
		</pre>
		</form>
      </body>
 </html>   
    
    
