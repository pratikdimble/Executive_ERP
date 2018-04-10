<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%> 
<%!int i;%> 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
   <%@ include file="JavaScript.jsp" %>
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
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Home</a>
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
<form action="./custreq" method="post">
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
  </tr>
    <c:forEach var="dto"  items="${listRequirementDTOs}">
    
     <tr>
     <h1 style="color:red">
      <td><input id="myRadio"  type="radio" name="choice" value="${dto.reqId}" onselect="showNewStock(this.value);"  onclick="showNewStock(this.value);document.getElementById('pid').value=this.value;document.getElementById('myid').removeAttribute('disabled');document.getElementById('myreject').removeAttribute('disabled'); ">${dto.reqId}</input></td>
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
<input type="hidden" name="pid" id="pid" readonly>
<div class="agile-username" id="productStock">
				<input type="hidden" name="quan" id="quan" style="width: 50px; height: 10px">
			</div>
    		 <button class="button" id="myid" type="submit" name="operation" value="Delivered" disabled>Delivered</button>
		<button class="button" id="myreject" type="submit" name="operation" value="Cancel" formaction="proddatacancel.jsp" formmethod="post" disabled>Cancel</button>
</form>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
<script type="text/javascript">

	function showNewStock(str){ 
var xmlhttp; 
if (window.XMLHttpRequest) 
{// code for IE7+, Firefox, Chrome, Opera, Safari 
xmlhttp=new XMLHttpRequest(); 
} 
else 
{// code for IE6, IE5 
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
} 
xmlhttp.onreadystatechange=function() 
{ 
if (xmlhttp.readyState==4 && xmlhttp.status==200) 
{ 
document.getElementById("productStock").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","newstockout.jsp?q="+str,true); 
xmlhttp.send(); 
} 

</script>
      </body>
 </html>   
    
    
