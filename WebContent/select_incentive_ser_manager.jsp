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
<title>Select Incentive Record::Service Manager</title>
<body  >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<!--     <a class="active" href="prod_manager_firstpage.jsp">Home</a> -->
<!--     <a href="display_incentive_prod_manager.jsp">Back</a> -->
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
<form method="POST" action="./incentive">
	<table id="customers">
<c:choose>
  <c:when test="${!empty listincentiveDTOs}">
   <tr>
	<th>Incentive ID</th>
	<th>Date</th>
    <th>Employee Name</th>
    <th>Service Name</th>
    <th>Service Provider</th>
    
    <th>Target Per Service</th>
    <th>Incentive Per Service(Rs.)</th>
    <th>Achieved Target</th>
    <th>Work Done</th>
    <th>Incentive Amount(Rs.)</th>
     <th>Operation</th>
  </tr>
    <c:forEach var="dto"  items="${listincentiveDTOs}">
    
     <tr>
     <h1 style="color:red">
   		 <td><input id="myRadio"  type="radio" name="choice" value="${dto.incId}" required="required">${dto.incId}</input></td>
   		 <td>${dto.incDate}</td>
   		 <td>${dto.empName}</td>
   		 <td>${dto.serName}</td>
   		 <td>${dto.provider}</td>
   		 
   		 <td>${dto.target}</td>
   		 <td>${dto.incentive}</td>
		 <td>${dto.achieved}</td>
   		 <td>${dto.workdone}</td>
   		 <td>${dto.amount}</td>
   		 <td><button id="myid" type="submit" name="operation" value="DELETE" onClick="return conf()">DELETE</button></td>
   		 </h1>
   		</tr>
    </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
 </table>
<%--   <h1 style="color:green">${incentiveRemovalMsg}</h1> --%>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
    </form>
  <script type="text/javascript">
function conf()
{
 if (!confirm("Do you want to Delete for sure?")) {
        return false;
    }
}
</script>

      </body>
 </html>   
    
    
