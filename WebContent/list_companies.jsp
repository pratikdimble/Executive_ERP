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
	<table id="customers">
<c:choose>
  <c:when test="${!empty listCompanyDTOs}">
   <tr>
	<th>Company ID</th>
    <th>Company Name</th>
    <th>Company Address</th>
     <th>Contact Number</th>
       <th>Company E-Mail</th>
        <th>Company Website</th>
         <th>Established Year</th>

  </tr>
    <c:forEach var="dto"  items="${listCompanyDTOs}">
    
     <tr>
     <h1 style="color:red">
   		 <td>${dto.compId}</td>
   		 <td>${dto.compName}</td>
   		 <td>${dto.compAddr}</td>
   		  <td>${dto.contact}</td>
   		    <td>${dto.compMail}</td>
   		     <td>${dto.compWeb}</td>
   		      <td>${dto.compYear}</td>
   		 </h1>
   		</tr>
          </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
  <h1 style="color:green">${CompanyRemovalMsg}</h1>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
      </body>
 </html>   
    
    
