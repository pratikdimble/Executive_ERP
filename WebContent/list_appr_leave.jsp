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
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="firstpage.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<form action="./leaveapp" method="POST">
	<table id="customers">
<c:choose>
  <c:when test="${!empty listLeaveDTOs}">
   <tr>
	<th>Leave ID</th>
	<th>Employee ID</th>
    <th>Employee Name</th>
    <th>Designation</th>
    
   	<th>Leave Type</th>
   	<th>Date From</th>
   	<th>Date To</th>
   	<th>Days</th>
   	<th>Status</th>
  </tr>
    <c:forEach var="dto"  items="${listLeaveDTOs}">
    
     <tr>
     <h1 style="color:red">
      <td><input id="myRadio"  type="radio" name="choice" value="${dto.leaveId}" onclick="document.getElementById('myid').removeAttribute('disabled')">${dto.leaveId}</input></td>
   		 <td>${dto.empId}</td>
   		 <td>${dto.empName}</td>
   		 <td>${dto.designation}</td>
   		 
   		 <td>${dto.leaveType}</td>
   		 <td>${dto.dateFrom}</td>
   		 <td>${dto.dateTo}</td>
   		 <td>${dto.days}</td>
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

</form>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
      </body>
 </html>   
    
    
